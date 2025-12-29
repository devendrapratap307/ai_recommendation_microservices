package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        log.info("Calling user service for userId: {} ", activityRequest.getUserId());
        boolean isValid = userValidationService.validateUser(activityRequest.getUserId());
        if (!isValid) {
            throw new RuntimeException("Invalid user id");
        }
        Activity activity = Activity.builder()
                .userId(activityRequest.getUserId())
                .type(activityRequest.getType())
                .startTime(activityRequest.getStartTime())
                .endTime(activityRequest.getEndTime())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .additionalProperties(activityRequest.getAdditionalProperties())
                .build();
        Activity activity1 = activityRepository.save(activity);
        return mapToResponse(activity1);
    }

    private ActivityResponse mapToResponse(Activity activity1) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(activity1.getId());
        activityResponse.setUserId(activity1.getUserId());
        activityResponse.setType(activity1.getType());
        activityResponse.setStartTime(activity1.getStartTime());
        activityResponse.setEndTime(activity1.getEndTime());
        activityResponse.setDuration(activity1.getDuration());
        activityResponse.setCaloriesBurned(activity1.getCaloriesBurned());
        activityResponse.setAdditionalProperties(activity1.getAdditionalProperties());
        activityResponse.setCreatedAt(activity1.getCreatedAt());
        activityResponse.setUpdatedAt(activity1.getUpdatedAt());
        return activityResponse;
    }
}

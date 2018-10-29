package com.example.kuanglin.podcastplayer.data;

import java.util.ArrayList;

public class PodcastManager {
    private static PodcastManager instance;
    private ArrayList<PodcastItem> list;

    public static PodcastManager getInstance() {
        if(instance == null) {
            instance = new PodcastManager();
        }
        return instance;
    }

    public ArrayList<PodcastItem> getPodcastList() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new PodcastItem("CouldBrexitChangeOurTravelPlans", "BrexitAGuideForThePerplexed-20170214-CouldBrexitChangeOurTravelPlans"));
            list.add(new PodcastItem("CanScotlandDoBrexitDifferently", "BrexitAGuideForThePerplexed-20170215-CanScotlandDoBrexitDifferently.mp3"));
            list.add(new PodcastItem("PreviewFlintoffDivingHaveYouNoSelfRespect", "FlintoffSavageAndThePingPongGuy-20170202-PreviewFlintoffDivingHaveYouNoSelfRespect.mp3"));
            list.add(new PodcastItem("SmellsLikeTeamSpirit", "FlintoffSavageAndThePingPongGuy-20170213-SmellsLikeTeamSpirit.mp3"));
            list.add(new PodcastItem("MurderInTheLuckyHolidayHotel", "IntrigueMurderInTheLuckyHolidayHotel-20170217-MurderInTheLuckyHolidayHotel.mp3"));
            list.add(new PodcastItem("ChristmasDayOmnibus", "TheListeningProject-20161225-ChristmasDayOmnibus.mp3"));
            list.add(new PodcastItem("OmnibusJoAndAndyDivorce", "TheListeningProject-20170119-OmnibusJoAndAndyDivorce.mp3"));
            list.add(new PodcastItem("OmnibusContendingWithDeath", "TheListeningProject-20170212-OmnibusContendingWithDeath.mp3"));
        }

        return list;
    }
}

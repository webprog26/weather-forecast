package com.webprog26.weatherforecast.data

fun getLocationMockData(): String {
    return "{\"Version\":1,\"Key\":\"324291\",\"Type\":\"City\",\"Rank\":41,\"LocalizedName\":\"Kropyvnytskyi\",\"EnglishName\":\"Kropyvnytskyi\",\"PrimaryPostalCode\":\"\",\"Region\":{\"ID\":\"EUR\",\"LocalizedName\":\"Europe\",\"EnglishName\":\"Europe\"},\"Country\":{\"ID\":\"UA\",\"LocalizedName\":\"Ukraine\",\"EnglishName\":\"Ukraine\"},\"AdministrativeArea\":{\"ID\":\"35\",\"LocalizedName\":\"Kirovohrad\",\"EnglishName\":\"Kirovohrad\",\"Level\":1,\"LocalizedType\":\"Province\",\"EnglishType\":\"Province\",\"CountryID\":\"UA\"},\"TimeZone\":{\"Code\":\"EEST\",\"Name\":\"Europe/Kiev\",\"GmtOffset\":3.0,\"IsDaylightSaving\":true,\"NextOffsetChange\":\"2020-10-25T01:00:00Z\"},\"GeoPosition\":{\"Latitude\":48.511,\"Longitude\":32.266,\"Elevation\":{\"Metric\":{\"Value\":120.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":393.0,\"Unit\":\"ft\",\"UnitType\":0}}},\"IsAlias\":false,\"SupplementalAdminAreas\":[],\"DataSets\":[\"AirQualityCurrentConditions\",\"AirQualityForecasts\",\"ForecastConfidence\"]}"
}

fun getDailyMockData() : String {
    return "{\"Headline\":{\"EffectiveDate\":\"2020-05-02T02:00:00+03:00\",\"EffectiveEpochDate\":1588374000,\"Severity\":2,\"Text\":\"Showers and thunderstorms around late Friday night through Sunday morning\",\"Category\":\"thunderstorm\",\"EndDate\":\"2020-05-03T14:00:00+03:00\",\"EndEpochDate\":1588503600,\"MobileLink\":\"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/extended-weather-forecast/324291?unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?unit=c&lang=en-us\"},\"DailyForecasts\":[{\"Date\":\"2020-04-28T07:00:00+03:00\",\"EpochDate\":1588046400,\"Temperature\":{\"Minimum\":{\"Value\":8.5,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":19.5,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":4,\"IconPhrase\":\"Intermittent clouds\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":34,\"IconPhrase\":\"Mostly clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\"}]}"
}

fun getHourlyMockData() : String {
    return "[\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T11:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588060800,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 15.7,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=11&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=11&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T12:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588064400,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 17,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=12&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=12&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T13:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588068000,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 18,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=13&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=13&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T14:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588071600,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 18.7,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=14&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=14&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T15:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588075200,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 18.8,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=15&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=15&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T16:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588078800,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 19.5,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=16&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=16&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T17:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588082400,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 18.9,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=17&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=17&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T18:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588086000,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 18,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=18&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=18&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T19:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588089600,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 17.1,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=19&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=19&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T20:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588093200,\n" +
            "    \"WeatherIcon\": 2,\n" +
            "    \"IconPhrase\": \"Mostly sunny\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 15,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=20&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=20&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T21:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588096800,\n" +
            "    \"WeatherIcon\": 34,\n" +
            "    \"IconPhrase\": \"Mostly clear\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": false,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 12.4,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=21&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=21&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-04-28T22:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1588100400,\n" +
            "    \"WeatherIcon\": 34,\n" +
            "    \"IconPhrase\": \"Mostly clear\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": false,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 11.6,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 0,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=22&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=22&unit=c&lang=en-us\"\n" +
            "  }\n" +
            "]"
}
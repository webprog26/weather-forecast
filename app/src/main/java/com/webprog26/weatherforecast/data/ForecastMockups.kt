package com.webprog26.weatherforecast.data

fun getLocationMockData(): String {
    return "{\n" +
            "  \"Version\": 1,\n" +
            "  \"Key\": \"324291\",\n" +
            "  \"Type\": \"City\",\n" +
            "  \"Rank\": 41,\n" +
            "  \"LocalizedName\": \"Kropyvnytskyi\",\n" +
            "  \"EnglishName\": \"Kropyvnytskyi\",\n" +
            "  \"PrimaryPostalCode\": \"\",\n" +
            "  \"Region\": {\n" +
            "    \"ID\": \"EUR\",\n" +
            "    \"LocalizedName\": \"Europe\",\n" +
            "    \"EnglishName\": \"Europe\"\n" +
            "  },\n" +
            "  \"Country\": {\n" +
            "    \"ID\": \"UA\",\n" +
            "    \"LocalizedName\": \"Ukraine\",\n" +
            "    \"EnglishName\": \"Ukraine\"\n" +
            "  },\n" +
            "  \"AdministrativeArea\": {\n" +
            "    \"ID\": \"35\",\n" +
            "    \"LocalizedName\": \"Kirovohrad\",\n" +
            "    \"EnglishName\": \"Kirovohrad\",\n" +
            "    \"Level\": 1,\n" +
            "    \"LocalizedType\": \"Province\",\n" +
            "    \"EnglishType\": \"Province\",\n" +
            "    \"CountryID\": \"UA\"\n" +
            "  },\n" +
            "  \"TimeZone\": {\n" +
            "    \"Code\": \"EEST\",\n" +
            "    \"Name\": \"Europe/Kiev\",\n" +
            "    \"GmtOffset\": 3,\n" +
            "    \"IsDaylightSaving\": true,\n" +
            "    \"NextOffsetChange\": \"2020-10-25T01:00:00Z\"\n" +
            "  },\n" +
            "  \"GeoPosition\": {\n" +
            "    \"Latitude\": 48.511,\n" +
            "    \"Longitude\": 32.266,\n" +
            "    \"Elevation\": {\n" +
            "      \"Metric\": {\n" +
            "        \"Value\": 120,\n" +
            "        \"Unit\": \"m\",\n" +
            "        \"UnitType\": 5\n" +
            "      },\n" +
            "      \"Imperial\": {\n" +
            "        \"Value\": 393,\n" +
            "        \"Unit\": \"ft\",\n" +
            "        \"UnitType\": 0\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"IsAlias\": false,\n" +
            "  \"SupplementalAdminAreas\": [],\n" +
            "  \"DataSets\": [\n" +
            "    \"AirQualityCurrentConditions\",\n" +
            "    \"AirQualityForecasts\",\n" +
            "    \"ForecastConfidence\"\n" +
            "  ]\n" +
            "}"
}

fun getDailyMockData() : String {
    return "{\n" +
            "  \"Headline\": {\n" +
            "    \"EffectiveDate\": \"2020-05-02T02:00:00+03:00\",\n" +
            "    \"EffectiveEpochDate\": 1588374000,\n" +
            "    \"Severity\": 2,\n" +
            "    \"Text\": \"Showers and thunderstorms around late Friday night through Sunday morning\",\n" +
            "    \"Category\": \"thunderstorm\",\n" +
            "    \"EndDate\": \"2020-05-03T14:00:00+03:00\",\n" +
            "    \"EndEpochDate\": 1588503600,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/extended-weather-forecast/324291?unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  \"DailyForecasts\": [\n" +
            "    {\n" +
            "      \"Date\": \"2020-04-28T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1588046400,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 8.5,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 19.5,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 4,\n" +
            "        \"IconPhrase\": \"Intermittent clouds\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 34,\n" +
            "        \"IconPhrase\": \"Mostly clear\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}

fun getHourlyMockData() : String {
    return "[\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T11:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589529600,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 14.7,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 43,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=11&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=11&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T12:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589533200,\n" +
            "    \"WeatherIcon\": 13,\n" +
            "    \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "    \"HasPrecipitation\": true,\n" +
            "    \"PrecipitationType\": \"Rain\",\n" +
            "    \"PrecipitationIntensity\": \"Light\",\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 16.1,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 51,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=12&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=12&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T13:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589536800,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 17.1,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 43,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=13&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=13&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T14:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589540400,\n" +
            "    \"WeatherIcon\": 13,\n" +
            "    \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "    \"HasPrecipitation\": true,\n" +
            "    \"PrecipitationType\": \"Rain\",\n" +
            "    \"PrecipitationIntensity\": \"Light\",\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 16.8,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 51,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=14&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=14&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T15:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589544000,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 16.8,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 47,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=15&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=15&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T16:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589547600,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 16,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 43,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=16&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=16&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T17:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589551200,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 14.7,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 43,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=17&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=17&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T18:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589554800,\n" +
            "    \"WeatherIcon\": 4,\n" +
            "    \"IconPhrase\": \"Intermittent clouds\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 13.5,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 47,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=18&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=18&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T19:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589558400,\n" +
            "    \"WeatherIcon\": 13,\n" +
            "    \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "    \"HasPrecipitation\": true,\n" +
            "    \"PrecipitationType\": \"Rain\",\n" +
            "    \"PrecipitationIntensity\": \"Light\",\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 13.6,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 51,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=19&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=19&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T20:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589562000,\n" +
            "    \"WeatherIcon\": 7,\n" +
            "    \"IconPhrase\": \"Cloudy\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": true,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 13.3,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 47,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=20&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=20&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T21:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589565600,\n" +
            "    \"WeatherIcon\": 7,\n" +
            "    \"IconPhrase\": \"Cloudy\",\n" +
            "    \"HasPrecipitation\": false,\n" +
            "    \"IsDaylight\": false,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 12.8,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 47,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=21&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=21&unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"DateTime\": \"2020-05-15T22:00:00+03:00\",\n" +
            "    \"EpochDateTime\": 1589569200,\n" +
            "    \"WeatherIcon\": 18,\n" +
            "    \"IconPhrase\": \"Rain\",\n" +
            "    \"HasPrecipitation\": true,\n" +
            "    \"PrecipitationType\": \"Rain\",\n" +
            "    \"PrecipitationIntensity\": \"Light\",\n" +
            "    \"IsDaylight\": false,\n" +
            "    \"Temperature\": {\n" +
            "      \"Value\": 12.1,\n" +
            "      \"Unit\": \"C\",\n" +
            "      \"UnitType\": 17\n" +
            "    },\n" +
            "    \"PrecipitationProbability\": 51,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=22&unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/hourly-weather-forecast/324291?day=1&hbhhour=22&unit=c&lang=en-us\"\n" +
            "  }\n" +
            "]"
}

fun get5DaysForecastMockData(): String {
    return "{\n" +
            "  \"Headline\": {\n" +
            "    \"EffectiveDate\": \"2020-05-15T08:00:00+03:00\",\n" +
            "    \"EffectiveEpochDate\": 1589518800,\n" +
            "    \"Severity\": 3,\n" +
            "    \"Text\": \"Expect rainy weather Friday morning through late Friday night\",\n" +
            "    \"Category\": \"rain\",\n" +
            "    \"EndDate\": \"2020-05-16T08:00:00+03:00\",\n" +
            "    \"EndEpochDate\": 1589605200,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/extended-weather-forecast/324291?unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  \"DailyForecasts\": [\n" +
            "    {\n" +
            "      \"Date\": \"2020-05-15T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1589515200,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 7.6,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 17.1,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 14,\n" +
            "        \"IconPhrase\": \"Partly sunny w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 18,\n" +
            "        \"IconPhrase\": \"Rain\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=1&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2020-05-16T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1589601600,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 6.4,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 17.6,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 6,\n" +
            "        \"IconPhrase\": \"Mostly cloudy\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 35,\n" +
            "        \"IconPhrase\": \"Partly cloudy\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=2&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=2&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2020-05-17T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1589688000,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 8.2,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 17.8,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 3,\n" +
            "        \"IconPhrase\": \"Partly sunny\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 39,\n" +
            "        \"IconPhrase\": \"Partly cloudy w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=3&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=3&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2020-05-18T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1589774400,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 6.8,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 20.6,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 2,\n" +
            "        \"IconPhrase\": \"Mostly sunny\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 36,\n" +
            "        \"IconPhrase\": \"Intermittent clouds\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=4&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=4&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2020-05-19T07:00:00+03:00\",\n" +
            "      \"EpochDate\": 1589860800,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 11.5,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 19.9,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 14,\n" +
            "        \"IconPhrase\": \"Partly sunny w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 38,\n" +
            "        \"IconPhrase\": \"Mostly cloudy\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=5&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ua/kropyvnytskyi/324291/daily-weather-forecast/324291?day=5&unit=c&lang=en-us\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}
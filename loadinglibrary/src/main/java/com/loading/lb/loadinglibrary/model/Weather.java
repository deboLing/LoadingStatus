package com.loading.lb.loadinglibrary.model;

/**
 * Created Time: 2017/11/15.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：
 */

public class Weather{

    /**
     * resultcode : 200
     * reason : 查询成功!
     * result : {"sk":{"temp":"21","wind_direction":"西风","wind_strength":"2级","humidity":"4%","time":"14:25"},"today":{"city":"天津","date_y":"2014年03月21日","week":"星期五","temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","dressing_index":"较冷","dressing_advice":"建议着大衣、呢外套加毛衣、卫衣等服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"较适宜","drying_index":""},"future":{"day_20140321":{"temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","week":"星期五","date":"20140321"},"day_20140322":{"temperature":"9℃~21℃","weather":"霾转多云","weather_id":{"fa":"53","fb":"01"},"wind":"东北风微风转东南风微风","week":"星期六","date":"20140322"},"day_20140323":{"temperature":"9℃~19℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期日","date":"20140323"},"day_20140324":{"temperature":"8℃~19℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"西南风微风转南风微风","week":"星期一","date":"20140324"},"day_20140325":{"temperature":"9℃~20℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期二","date":"20140325"},"day_20140326":{"temperature":"10℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期三","date":"20140326"},"day_20140327":{"temperature":"11℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"南风微风转无持续风向微风","week":"星期四","date":"20140327"}}}
     */

    private String resultcode;
    private String reason;
    private ResultBean result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"21","wind_direction":"西风","wind_strength":"2级","humidity":"4%","time":"14:25"}
         * today : {"city":"天津","date_y":"2014年03月21日","week":"星期五","temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","dressing_index":"较冷","dressing_advice":"建议着大衣、呢外套加毛衣、卫衣等服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"较适宜","drying_index":""}
         * future : {"day_20140321":{"temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","week":"星期五","date":"20140321"},"day_20140322":{"temperature":"9℃~21℃","weather":"霾转多云","weather_id":{"fa":"53","fb":"01"},"wind":"东北风微风转东南风微风","week":"星期六","date":"20140322"},"day_20140323":{"temperature":"9℃~19℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期日","date":"20140323"},"day_20140324":{"temperature":"8℃~19℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"西南风微风转南风微风","week":"星期一","date":"20140324"},"day_20140325":{"temperature":"9℃~20℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期二","date":"20140325"},"day_20140326":{"temperature":"10℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期三","date":"20140326"},"day_20140327":{"temperature":"11℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"南风微风转无持续风向微风","week":"星期四","date":"20140327"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 21
             * wind_direction : 西风
             * wind_strength : 2级
             * humidity : 4%
             * time : 14:25
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * city : 天津
             * date_y : 2014年03月21日
             * week : 星期五
             * temperature : 8℃~20℃
             * weather : 晴转霾
             * weather_id : {"fa":"00","fb":"53"}
             * wind : 西南风微风
             * dressing_index : 较冷
             * dressing_advice : 建议着大衣、呢外套加毛衣、卫衣等服装。
             * uv_index : 中等
             * comfort_index :
             * wash_index : 较适宜
             * travel_index : 适宜
             * exercise_index : 较适宜
             * drying_index :
             */

            private String city;
            private String date_y;
            private String week;
            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 00
                 * fb : 53
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20140321 : {"temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","week":"星期五","date":"20140321"}
             * day_20140322 : {"temperature":"9℃~21℃","weather":"霾转多云","weather_id":{"fa":"53","fb":"01"},"wind":"东北风微风转东南风微风","week":"星期六","date":"20140322"}
             * day_20140323 : {"temperature":"9℃~19℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期日","date":"20140323"}
             * day_20140324 : {"temperature":"8℃~19℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"西南风微风转南风微风","week":"星期一","date":"20140324"}
             * day_20140325 : {"temperature":"9℃~20℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期二","date":"20140325"}
             * day_20140326 : {"temperature":"10℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期三","date":"20140326"}
             * day_20140327 : {"temperature":"11℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"南风微风转无持续风向微风","week":"星期四","date":"20140327"}
             */

            private Day20140321Bean day_20140321;
            private Day20140322Bean day_20140322;
            private Day20140323Bean day_20140323;
            private Day20140324Bean day_20140324;
            private Day20140325Bean day_20140325;
            private Day20140326Bean day_20140326;
            private Day20140327Bean day_20140327;

            public Day20140321Bean getDay_20140321() {
                return day_20140321;
            }

            public void setDay_20140321(Day20140321Bean day_20140321) {
                this.day_20140321 = day_20140321;
            }

            public Day20140322Bean getDay_20140322() {
                return day_20140322;
            }

            public void setDay_20140322(Day20140322Bean day_20140322) {
                this.day_20140322 = day_20140322;
            }

            public Day20140323Bean getDay_20140323() {
                return day_20140323;
            }

            public void setDay_20140323(Day20140323Bean day_20140323) {
                this.day_20140323 = day_20140323;
            }

            public Day20140324Bean getDay_20140324() {
                return day_20140324;
            }

            public void setDay_20140324(Day20140324Bean day_20140324) {
                this.day_20140324 = day_20140324;
            }

            public Day20140325Bean getDay_20140325() {
                return day_20140325;
            }

            public void setDay_20140325(Day20140325Bean day_20140325) {
                this.day_20140325 = day_20140325;
            }

            public Day20140326Bean getDay_20140326() {
                return day_20140326;
            }

            public void setDay_20140326(Day20140326Bean day_20140326) {
                this.day_20140326 = day_20140326;
            }

            public Day20140327Bean getDay_20140327() {
                return day_20140327;
            }

            public void setDay_20140327(Day20140327Bean day_20140327) {
                this.day_20140327 = day_20140327;
            }

            public static class Day20140321Bean {
                /**
                 * temperature : 8℃~20℃
                 * weather : 晴转霾
                 * weather_id : {"fa":"00","fb":"53"}
                 * wind : 西南风微风
                 * week : 星期五
                 * date : 20140321
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 00
                     * fb : 53
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140322Bean {
                /**
                 * temperature : 9℃~21℃
                 * weather : 霾转多云
                 * weather_id : {"fa":"53","fb":"01"}
                 * wind : 东北风微风转东南风微风
                 * week : 星期六
                 * date : 20140322
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXX {
                    /**
                     * fa : 53
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140323Bean {
                /**
                 * temperature : 9℃~19℃
                 * weather : 阴
                 * weather_id : {"fa":"02","fb":"02"}
                 * wind : 南风微风
                 * week : 星期日
                 * date : 20140323
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXX {
                    /**
                     * fa : 02
                     * fb : 02
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140324Bean {
                /**
                 * temperature : 8℃~19℃
                 * weather : 晴转多云
                 * weather_id : {"fa":"00","fb":"01"}
                 * wind : 西南风微风转南风微风
                 * week : 星期一
                 * date : 20140324
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXX {
                    /**
                     * fa : 00
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140325Bean {
                /**
                 * temperature : 9℃~20℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 南风微风
                 * week : 星期二
                 * date : 20140325
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140326Bean {
                /**
                 * temperature : 10℃~19℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 南风微风
                 * week : 星期三
                 * date : 20140326
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20140327Bean {
                /**
                 * temperature : 11℃~20℃
                 * weather : 阴转多云
                 * weather_id : {"fa":"02","fb":"01"}
                 * wind : 南风微风转无持续风向微风
                 * week : 星期四
                 * date : 20140327
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 02
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}

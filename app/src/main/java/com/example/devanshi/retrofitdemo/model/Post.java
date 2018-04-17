package com.example.devanshi.retrofitdemo.model;

import java.util.List;

/**
 * Created by Devanshi on 05-03-2018.
 */

public class Post
{



    /**
     * status : 1
     * login : 1
     * message : Success
     * data : {"baskets":[{"id":1,"b_name":"Agriculture, Food and Natural Resources","b_intro":"<p>description of basket<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374500.jpg","b_video_type":2,"b_video":"R8pccTlKl8M","b_points":0,"created_at":"2016-04-20 01:35:30","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":2,"b_name":"Architecture and Construction","b_intro":"<p>basket2 description<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374526.jpg","b_video_type":2,"b_video":"yKagd5PJ2KA","b_points":0,"created_at":"2016-04-21 00:56:34","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":3,"b_name":"Arts, Audio-Video Media, Mass Communication","b_intro":"<p>test<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517377237.jpg","b_video_type":2,"b_video":"FrbYJmU6p6Q","b_points":0,"created_at":"2016-05-03 09:37:13","updated_at":"2018-03-01 12:58:00","deleted":1,"type_video":"1"},{"id":4,"b_name":"Business and Administration","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Business and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Administration<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374974.jpg","b_video_type":2,"b_video":"TP_yK7N5Tuk","b_points":0,"created_at":"2016-05-03 09:38:02","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":5,"b_name":"Education and Training","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Education<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Training<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374997.jpg","b_video_type":2,"b_video":"P0gKAJMA4ZQ","b_points":400,"created_at":"2016-05-03 09:38:39","updated_at":"2018-03-01 12:58:03","deleted":1,"type_video":"1"},{"id":6,"b_name":"Finance","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Finance<\/strong><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375695.jpg","b_video_type":2,"b_video":"8DzEIzIbwAE","b_points":0,"created_at":"2016-05-03 09:39:00","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":7,"b_name":"Government and Public Administration","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Government<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>and Public<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Administration<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375716.jpg","b_video_type":2,"b_video":"hFfsMsCm3yQ","b_points":0,"created_at":"2016-05-03 09:39:24","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":8,"b_name":"Health Sciences","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Health<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Sciences<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375740.jpg","b_video_type":2,"b_video":"MQeGOvFEDHA","b_points":0,"created_at":"2016-05-03 09:39:53","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":9,"b_name":"Hospitality and Tourism","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Hospitality and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Tourism<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375762.jpg","b_video_type":2,"b_video":"GuzRhIiPx-U","b_points":0,"created_at":"2016-05-03 09:40:43","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":10,"b_name":"Human Services","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Human<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Services<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375784.jpg","b_video_type":2,"b_video":"Bmbp7z_hmqM","b_points":0,"created_at":"2016-05-03 09:41:04","updated_at":"2018-03-01 12:57:18","deleted":1,"type_video":"1"},{"id":11,"b_name":"Information Technology","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Information<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Technology<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375830.jpg","b_video_type":2,"b_video":"Rnf2hdIlFzY","b_points":0,"created_at":"2016-05-03 09:41:29","updated_at":"2018-03-01 12:57:58","deleted":1,"type_video":"1"},{"id":12,"b_name":"Law and Public Safety","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Law and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Public<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Safety<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375854.jpg","b_video_type":2,"b_video":"ifZFMubsxuo","b_points":0,"created_at":"2016-05-03 09:41:59","updated_at":"2018-03-01 12:58:05","deleted":1,"type_video":"1"},{"id":13,"b_name":"Manufacturing","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Manufacturing<\/strong><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375877.jpg","b_video_type":2,"b_video":"N7KOmT59ej4","b_points":0,"created_at":"2016-05-03 09:42:26","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":14,"b_name":"Direct / Retail / Wholesale - Sales and Marketing","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Direct / Retail /<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Wholesale -<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Sales and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Marketing<\/strong><\/span><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375908.jpg","b_video_type":2,"b_video":"hjK7VoIDfxE","b_points":0,"created_at":"2016-05-03 09:43:29","updated_at":"2018-03-01 12:58:05","deleted":1,"type_video":"1"},{"id":15,"b_name":"Scientific Research, Engineering","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Scientific<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Research,<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Engineering<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375932.jpg","b_video_type":2,"b_video":"X2txAxpgRHw","b_points":0,"created_at":"2016-05-03 09:44:04","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":16,"b_name":"Transportation, Distribution, Logistics","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Transportation<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>, Distribution,<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Logistics<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375958.jpg","b_video_type":2,"b_video":"GBFsVX_8_AU","b_points":0,"created_at":"2016-05-03 09:44:31","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"}],"total_profession":"200","completed_profession":"123"}
     */

    private int status;
    private int login;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * baskets : [{"id":1,"b_name":"Agriculture, Food and Natural Resources","b_intro":"<p>description of basket<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374500.jpg","b_video_type":2,"b_video":"R8pccTlKl8M","b_points":0,"created_at":"2016-04-20 01:35:30","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":2,"b_name":"Architecture and Construction","b_intro":"<p>basket2 description<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374526.jpg","b_video_type":2,"b_video":"yKagd5PJ2KA","b_points":0,"created_at":"2016-04-21 00:56:34","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":3,"b_name":"Arts, Audio-Video Media, Mass Communication","b_intro":"<p>test<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517377237.jpg","b_video_type":2,"b_video":"FrbYJmU6p6Q","b_points":0,"created_at":"2016-05-03 09:37:13","updated_at":"2018-03-01 12:58:00","deleted":1,"type_video":"1"},{"id":4,"b_name":"Business and Administration","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Business and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Administration<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374974.jpg","b_video_type":2,"b_video":"TP_yK7N5Tuk","b_points":0,"created_at":"2016-05-03 09:38:02","updated_at":"2018-03-01 12:58:02","deleted":1,"type_video":"1"},{"id":5,"b_name":"Education and Training","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Education<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Training<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374997.jpg","b_video_type":2,"b_video":"P0gKAJMA4ZQ","b_points":400,"created_at":"2016-05-03 09:38:39","updated_at":"2018-03-01 12:58:03","deleted":1,"type_video":"1"},{"id":6,"b_name":"Finance","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Finance<\/strong><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375695.jpg","b_video_type":2,"b_video":"8DzEIzIbwAE","b_points":0,"created_at":"2016-05-03 09:39:00","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":7,"b_name":"Government and Public Administration","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Government<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>and Public<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Administration<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375716.jpg","b_video_type":2,"b_video":"hFfsMsCm3yQ","b_points":0,"created_at":"2016-05-03 09:39:24","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":8,"b_name":"Health Sciences","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Health<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Sciences<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375740.jpg","b_video_type":2,"b_video":"MQeGOvFEDHA","b_points":0,"created_at":"2016-05-03 09:39:53","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":9,"b_name":"Hospitality and Tourism","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Hospitality and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Tourism<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375762.jpg","b_video_type":2,"b_video":"GuzRhIiPx-U","b_points":0,"created_at":"2016-05-03 09:40:43","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":10,"b_name":"Human Services","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Human<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Services<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375784.jpg","b_video_type":2,"b_video":"Bmbp7z_hmqM","b_points":0,"created_at":"2016-05-03 09:41:04","updated_at":"2018-03-01 12:57:18","deleted":1,"type_video":"1"},{"id":11,"b_name":"Information Technology","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Information<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Technology<\/strong><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375830.jpg","b_video_type":2,"b_video":"Rnf2hdIlFzY","b_points":0,"created_at":"2016-05-03 09:41:29","updated_at":"2018-03-01 12:57:58","deleted":1,"type_video":"1"},{"id":12,"b_name":"Law and Public Safety","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Law and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Public<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Safety<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375854.jpg","b_video_type":2,"b_video":"ifZFMubsxuo","b_points":0,"created_at":"2016-05-03 09:41:59","updated_at":"2018-03-01 12:58:05","deleted":1,"type_video":"1"},{"id":13,"b_name":"Manufacturing","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Manufacturing<\/strong><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375877.jpg","b_video_type":2,"b_video":"N7KOmT59ej4","b_points":0,"created_at":"2016-05-03 09:42:26","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"},{"id":14,"b_name":"Direct / Retail / Wholesale - Sales and Marketing","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Direct / Retail /<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Wholesale -<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Sales and<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Marketing<\/strong><\/span><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375908.jpg","b_video_type":2,"b_video":"hjK7VoIDfxE","b_points":0,"created_at":"2016-05-03 09:43:29","updated_at":"2018-03-01 12:58:05","deleted":1,"type_video":"1"},{"id":15,"b_name":"Scientific Research, Engineering","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Scientific<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Research,<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Engineering<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375932.jpg","b_video_type":2,"b_video":"X2txAxpgRHw","b_points":0,"created_at":"2016-05-03 09:44:04","updated_at":"2018-03-01 12:58:09","deleted":1,"type_video":"1"},{"id":16,"b_name":"Transportation, Distribution, Logistics","b_intro":"<p><span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Transportation<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>, Distribution,<\/strong><br />\r\n<span style=\"color:rgb(0,0,0); font-family:calibri,bold; font-size:3pt\"><strong>Logistics<\/strong><\/span><\/span><\/span><br />\r\n&nbsp;<\/p>\r\n","b_logo":"https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517375958.jpg","b_video_type":2,"b_video":"GBFsVX_8_AU","b_points":0,"created_at":"2016-05-03 09:44:31","updated_at":"2018-03-01 12:58:06","deleted":1,"type_video":"1"}]
         * total_profession : 200
         * completed_profession : 123
         */

        private String total_profession;
        private String completed_profession;
        private List<BasketsBean> baskets;

        public String getTotal_profession() {
            return total_profession;
        }

        public void setTotal_profession(String total_profession) {
            this.total_profession = total_profession;
        }

        public String getCompleted_profession() {
            return completed_profession;
        }

        public void setCompleted_profession(String completed_profession) {
            this.completed_profession = completed_profession;
        }

        public List<BasketsBean> getBaskets() {
            return baskets;
        }

        public void setBaskets(List<BasketsBean> baskets) {
            this.baskets = baskets;
        }

        public static class BasketsBean {
            /**
             * id : 1
             * b_name : Agriculture, Food and Natural Resources
             * b_intro : <p>description of basket</p>

             * b_logo : https://s3proteen.s3.ap-south-1.amazonaws.com/uploads/basket/thumb/basket_1517374500.jpg
             * b_video_type : 2
             * b_video : R8pccTlKl8M
             * b_points : 0
             * created_at : 2016-04-20 01:35:30
             * updated_at : 2018-03-01 12:58:02
             * deleted : 1
             * type_video : 1
             */

            private int id;
            private String b_name;
            private String b_intro;
            private String b_logo;
            private int b_video_type;
            private String b_video;
            private int b_points;
            private String created_at;
            private String updated_at;
            private int deleted;
            private String type_video;
            private boolean isChecked;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getB_name() {
                return b_name;
            }

            public void setB_name(String b_name) {
                this.b_name = b_name;
            }

            public String getB_intro() {
                return b_intro;
            }

            public void setB_intro(String b_intro) {
                this.b_intro = b_intro;
            }

            public String getB_logo() {
                return b_logo;
            }

            public void setB_logo(String b_logo) {
                this.b_logo = b_logo;
            }

            public int getB_video_type() {
                return b_video_type;
            }

            public void setB_video_type(int b_video_type) {
                this.b_video_type = b_video_type;
            }

            public String getB_video() {
                return b_video;
            }

            public void setB_video(String b_video) {
                this.b_video = b_video;
            }

            public int getB_points() {
                return b_points;
            }

            public void setB_points(int b_points) {
                this.b_points = b_points;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public String getType_video() {
                return type_video;
            }

            public void setType_video(String type_video) {
                this.type_video = type_video;
            }
            public boolean getChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }
        }
    }
}



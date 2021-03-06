var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "63720",
        "ok": "62321",
        "ko": "1399"
    },
    "minResponseTime": {
        "total": "487",
        "ok": "489",
        "ko": "487"
    },
    "maxResponseTime": {
        "total": "30946",
        "ok": "30946",
        "ko": "21357"
    },
    "meanResponseTime": {
        "total": "2364",
        "ok": "2358",
        "ko": "2621"
    },
    "standardDeviation": {
        "total": "2393",
        "ok": "2380",
        "ko": "2932"
    },
    "percentiles1": {
        "total": "1641",
        "ok": "1642",
        "ko": "1504"
    },
    "percentiles2": {
        "total": "3168",
        "ok": "3155",
        "ko": "3712"
    },
    "percentiles3": {
        "total": "6817",
        "ok": "6774",
        "ko": "9099"
    },
    "percentiles4": {
        "total": "12271",
        "ok": "12249",
        "ko": "12965"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 19395,
    "percentage": 30
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8915,
    "percentage": 14
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 34011,
    "percentage": 53
},
    "group4": {
    "name": "failed",
    "count": 1399,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "340.749",
        "ok": "333.267",
        "ko": "7.481"
    }
},
contents: {
"req_get-all-activit-6776d": {
        type: "REQUEST",
        name: "Get all activities",
path: "Get all activities",
pathFormatted: "req_get-all-activit-6776d",
stats: {
    "name": "Get all activities",
    "numberOfRequests": {
        "total": "63720",
        "ok": "62321",
        "ko": "1399"
    },
    "minResponseTime": {
        "total": "487",
        "ok": "489",
        "ko": "487"
    },
    "maxResponseTime": {
        "total": "30946",
        "ok": "30946",
        "ko": "21357"
    },
    "meanResponseTime": {
        "total": "2364",
        "ok": "2358",
        "ko": "2621"
    },
    "standardDeviation": {
        "total": "2393",
        "ok": "2380",
        "ko": "2932"
    },
    "percentiles1": {
        "total": "1641",
        "ok": "1642",
        "ko": "1504"
    },
    "percentiles2": {
        "total": "3168",
        "ok": "3155",
        "ko": "3712"
    },
    "percentiles3": {
        "total": "6817",
        "ok": "6774",
        "ko": "9099"
    },
    "percentiles4": {
        "total": "12271",
        "ok": "12249",
        "ko": "12965"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 19395,
    "percentage": 30
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8915,
    "percentage": 14
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 34011,
    "percentage": 53
},
    "group4": {
    "name": "failed",
    "count": 1399,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "340.749",
        "ok": "333.267",
        "ko": "7.481"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}

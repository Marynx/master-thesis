var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "9031",
        "ok": "9031",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "137",
        "ok": "137",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3664",
        "ok": "3664",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "164",
        "ok": "164",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "107",
        "ok": "107",
        "ko": "-"
    },
    "percentiles1": {
        "total": "150",
        "ok": "150",
        "ko": "-"
    },
    "percentiles2": {
        "total": "159",
        "ok": "159",
        "ko": "-"
    },
    "percentiles3": {
        "total": "203",
        "ok": "203",
        "ko": "-"
    },
    "percentiles4": {
        "total": "344",
        "ok": "344",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 9021,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "49.621",
        "ok": "49.621",
        "ko": "-"
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
        "total": "9031",
        "ok": "9031",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "137",
        "ok": "137",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3664",
        "ok": "3664",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "164",
        "ok": "164",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "107",
        "ok": "107",
        "ko": "-"
    },
    "percentiles1": {
        "total": "150",
        "ok": "150",
        "ko": "-"
    },
    "percentiles2": {
        "total": "159",
        "ok": "159",
        "ko": "-"
    },
    "percentiles3": {
        "total": "203",
        "ok": "203",
        "ko": "-"
    },
    "percentiles4": {
        "total": "344",
        "ok": "344",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 9021,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "49.621",
        "ok": "49.621",
        "ko": "-"
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

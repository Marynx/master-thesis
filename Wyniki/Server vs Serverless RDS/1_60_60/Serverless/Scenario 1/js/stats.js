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
        "total": "486",
        "ok": "486",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4401",
        "ok": "4401",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "536",
        "ok": "536",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "151",
        "ok": "151",
        "ko": "-"
    },
    "percentiles1": {
        "total": "511",
        "ok": "511",
        "ko": "-"
    },
    "percentiles2": {
        "total": "530",
        "ok": "530",
        "ko": "-"
    },
    "percentiles3": {
        "total": "663",
        "ok": "663",
        "ko": "-"
    },
    "percentiles4": {
        "total": "817",
        "ok": "817",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 8922,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 95,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 14,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "49.895",
        "ok": "49.895",
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
        "total": "486",
        "ok": "486",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4401",
        "ok": "4401",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "536",
        "ok": "536",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "151",
        "ok": "151",
        "ko": "-"
    },
    "percentiles1": {
        "total": "511",
        "ok": "511",
        "ko": "-"
    },
    "percentiles2": {
        "total": "530",
        "ok": "530",
        "ko": "-"
    },
    "percentiles3": {
        "total": "663",
        "ok": "663",
        "ko": "-"
    },
    "percentiles4": {
        "total": "817",
        "ok": "817",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 8922,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 95,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 14,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "49.895",
        "ok": "49.895",
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

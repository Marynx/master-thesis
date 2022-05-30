var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "63720",
        "ok": "37647",
        "ko": "26073"
    },
    "minResponseTime": {
        "total": "127",
        "ok": "129",
        "ko": "127"
    },
    "maxResponseTime": {
        "total": "3469",
        "ok": "3469",
        "ko": "3349"
    },
    "meanResponseTime": {
        "total": "161",
        "ok": "148",
        "ko": "180"
    },
    "standardDeviation": {
        "total": "219",
        "ok": "116",
        "ko": "311"
    },
    "percentiles1": {
        "total": "137",
        "ok": "138",
        "ko": "136"
    },
    "percentiles2": {
        "total": "141",
        "ok": "141",
        "ko": "140"
    },
    "percentiles3": {
        "total": "172",
        "ok": "168",
        "ko": "187"
    },
    "percentiles4": {
        "total": "346",
        "ok": "266",
        "ko": "2664"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 37586,
    "percentage": 59
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 2,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 59,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 26073,
    "percentage": 41
},
    "meanNumberOfRequestsPerSecond": {
        "total": "350.11",
        "ok": "206.852",
        "ko": "143.258"
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
        "ok": "37647",
        "ko": "26073"
    },
    "minResponseTime": {
        "total": "127",
        "ok": "129",
        "ko": "127"
    },
    "maxResponseTime": {
        "total": "3469",
        "ok": "3469",
        "ko": "3349"
    },
    "meanResponseTime": {
        "total": "161",
        "ok": "148",
        "ko": "180"
    },
    "standardDeviation": {
        "total": "219",
        "ok": "116",
        "ko": "311"
    },
    "percentiles1": {
        "total": "137",
        "ok": "138",
        "ko": "136"
    },
    "percentiles2": {
        "total": "141",
        "ok": "141",
        "ko": "140"
    },
    "percentiles3": {
        "total": "172",
        "ok": "168",
        "ko": "187"
    },
    "percentiles4": {
        "total": "346",
        "ok": "266",
        "ko": "2664"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 37586,
    "percentage": 59
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 2,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 59,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 26073,
    "percentage": 41
},
    "meanNumberOfRequestsPerSecond": {
        "total": "350.11",
        "ok": "206.852",
        "ko": "143.258"
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

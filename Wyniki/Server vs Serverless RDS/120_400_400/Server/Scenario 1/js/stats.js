var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "63720",
        "ok": "63719",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "240",
        "ok": "240",
        "ko": "10006"
    },
    "maxResponseTime": {
        "total": "12523",
        "ok": "12523",
        "ko": "10006"
    },
    "meanResponseTime": {
        "total": "509",
        "ok": "508",
        "ko": "10006"
    },
    "standardDeviation": {
        "total": "685",
        "ok": "684",
        "ko": "0"
    },
    "percentiles1": {
        "total": "272",
        "ok": "272",
        "ko": "10006"
    },
    "percentiles2": {
        "total": "395",
        "ok": "395",
        "ko": "10006"
    },
    "percentiles3": {
        "total": "1787",
        "ok": "1787",
        "ko": "10006"
    },
    "percentiles4": {
        "total": "3578",
        "ok": "3577",
        "ko": "10006"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 56765,
    "percentage": 89
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1344,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5610,
    "percentage": 9
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "352.044",
        "ok": "352.039",
        "ko": "0.006"
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
        "ok": "63719",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "240",
        "ok": "240",
        "ko": "10006"
    },
    "maxResponseTime": {
        "total": "12523",
        "ok": "12523",
        "ko": "10006"
    },
    "meanResponseTime": {
        "total": "509",
        "ok": "508",
        "ko": "10006"
    },
    "standardDeviation": {
        "total": "685",
        "ok": "684",
        "ko": "0"
    },
    "percentiles1": {
        "total": "272",
        "ok": "272",
        "ko": "10006"
    },
    "percentiles2": {
        "total": "395",
        "ok": "395",
        "ko": "10006"
    },
    "percentiles3": {
        "total": "1787",
        "ok": "1787",
        "ko": "10006"
    },
    "percentiles4": {
        "total": "3578",
        "ok": "3577",
        "ko": "10006"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 56765,
    "percentage": 89
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1344,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5610,
    "percentage": 9
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "352.044",
        "ok": "352.039",
        "ko": "0.006"
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

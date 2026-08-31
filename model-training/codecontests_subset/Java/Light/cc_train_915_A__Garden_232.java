const 
    conditions = readline().split(' '),
    buckets = readline().split(' '),
    bucketsCount = conditions[0],
    gardenLength = conditions[1];

var result = buckets.reduce((a, b) => {
    if (gardenLength % b === 0 && gardenLength / b < a) {
        return gardenLength / b;
    }
    return a;
}, gardenLength);

print(result)
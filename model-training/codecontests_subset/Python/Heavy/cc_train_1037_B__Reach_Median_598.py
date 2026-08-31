import sys
import math

def main():
    n, s = [int(x) for x in sys.stdin.readline().split(" ")]
    nums = [int(x) for x in sys.stdin.readline().split(" ")]
    low = []
    high = []
    sCount = 0
    numChanges = 0
    for x in nums:
        if (x == s):
            sCount += 1
        elif (x < s):
            low.append(x)
        else:
            high.append(x)
    low.sort()
    low.reverse()
    high.sort()
    diff = len(high) - len(low)
    midPoint = n // 2
    biggerLength = max(len(low), len(high))
    changesNeeded = (biggerLength - midPoint)
#    print("midPoint: {}, biggerLength: {}".format(midPoint, biggerLength))
#    print("changesNeeded: {}".format(changesNeeded))
#    print("diff: {}, low: {}, high: {}, sCount: {}".format(diff, len(low), len(high), sCount))
#    print("low: {}, high: {}".format(low, high))
    
    if (diff > sCount):
        for i in range(changesNeeded):
            numChanges += high[i] - s
    elif (diff < sCount):
        for i in range(changesNeeded):
            numChanges += s - low[i]
#    print("Abadaba: {}".format(abs(sCount + diff)))
    return(numChanges)

print(main())

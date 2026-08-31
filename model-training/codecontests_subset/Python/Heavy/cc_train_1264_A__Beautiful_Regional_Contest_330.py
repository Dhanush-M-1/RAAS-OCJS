import sys
readline = sys.stdin.readline
mr = lambda: map(int, readline().split())
t = int(readline())
Ans = []

for _ in range(t):
    n = int(readline())
    monsters = list(mr())
    counter = 1
    tmpArr = []
    for i in range(1,n):
        if monsters[i] == monsters[i - 1]:
            counter += 1
        else:
            tmpArr.append(counter)
            counter = 1
    tmpArr.append(counter)

    gCount = tmpArr[0]
    sCount = 0
    bCount = 0
    sum = gCount
    for i in range(1,len(tmpArr)):
        if(sCount <= gCount):
            sCount += tmpArr[i]
            sum += tmpArr[i]
        else:
            if sum <= n // 2:
                bCount += tmpArr[i]
                sum += tmpArr[i]
            else:
                bCount -= tmpArr[i - 1]
                sum -= tmpArr[i - 1]
                break
    if sum > n//2:
        bCount -= tmpArr[len(tmpArr) - 1]
    if(sCount > gCount and bCount > gCount):
        Ans.append(str(gCount) + " " + str(sCount) + " " + str(bCount))
    else:
        Ans.append("0 0 0")

print("\n".join(map(str, Ans)))
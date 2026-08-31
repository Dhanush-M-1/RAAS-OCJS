def ans(n):
    flag = True
    lastP, lastC = 0, 0
    for i in range(n):
        newP, newC = map(int, input().split())
        if i == 0:
            if not (newP >= newC):
                flag = False
            lastP, lastC = newP, newC
        else:
            if newP >= lastP and newC >= lastC:
                newClears = newC - lastC
                newPlays = newP - lastP
                if not (newPlays >= newClears):
                    flag = False
                lastP, lastC = newP, newC
            else:
                flag = False
    return flag


for t in range(int(input())):
    n = int(input())

    if ans(n):
        print("YES")
    else:
        print("NO")



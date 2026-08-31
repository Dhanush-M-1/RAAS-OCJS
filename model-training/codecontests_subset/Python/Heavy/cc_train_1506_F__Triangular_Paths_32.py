import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    res=[]
    for i in range(n):
        res.append([r[i], c[i]])
    res.sort()
    lastp, lastq = 1, 1
    ans = 0
    i=0
    while (i<n):
        currp,currq=res[i][0],res[i][1]
        if currp - currq == lastp - lastq:
            if (currp - currq) % 2==0:
                ans += currp - lastp
        elif currp - currq >= lastp - lastq:
           
            ans += (currp - currq) // 2 - (lastp - lastq) // 2
        lastp, lastq = currp, currq

        i+=1
    print(ans)
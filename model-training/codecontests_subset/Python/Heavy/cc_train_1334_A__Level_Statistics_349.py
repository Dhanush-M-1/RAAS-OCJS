# import sys
for _ in range(int(input())):
    n = int(input())
    ans = "YES"
    previous = 0
    for i in range(n):
        if previous==0:
            previous = list(map(int,input().split()))
            if previous[0]<previous[1]:
                ans = "NO"
        else:
            new = list(map(int,input().split()))
            if ans != "NO":
                if new[0]<new[1]:
                    ans = "NO"
                if new[0] < previous[0] or new[1] < previous[1]:
                    ans = "NO"
                if new[0]-new[1] < previous[0]-previous[1]:
                    ans = "NO"
                previous = new
    print(ans)
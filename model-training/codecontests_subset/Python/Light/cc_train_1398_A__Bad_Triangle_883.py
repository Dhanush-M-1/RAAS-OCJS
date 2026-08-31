t=int(input())
#only show 1 example
for _ in range(t):
    n=int(input())
    *a,= map(int,input().split())
    ai=[(a[i],i+1) for i in range(n)]
    ai.sort()
    if ai[0][0]+ai[1][0]<=ai[-1][0]:
        print(ai[0][1],ai[1][1],ai[-1][1])
    else:
        print(-1)
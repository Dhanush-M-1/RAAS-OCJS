t = int(input())
for i in range(t):
    n = int(input())
    ai = list(map(int,input().split()))
    if ai[-1] - ai[0] - ai[1] >= 0:
        print(1,2,n)
    else:
        print(-1)

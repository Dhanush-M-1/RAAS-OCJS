t=int(input())
for i in range(t):
    n=int(input())
    b=list(map(int,input().split()))
    if (b[0]+b[1])<=b[-1]:
        print(1, 2, n)
    else:
        print(-1)

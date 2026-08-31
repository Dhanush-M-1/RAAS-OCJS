t=int(input())
while(t>0):
    n=int(input())
    ar=list(map(int, input().split()))
    if ar[0]+ar[1]<=ar[n-1]:
        print(1, 2, n)
    else:
        print(-1)
    t-=1
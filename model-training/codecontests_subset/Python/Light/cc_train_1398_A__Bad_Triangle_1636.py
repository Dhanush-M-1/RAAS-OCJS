t = int(input())
while(t):
    n = int(input())
    arr = list(map(int, input().split()))
    flag1=0
    index=n-1
    if (arr[0]+arr[1]<=arr[n-1]):
        print(1,2,n)
    else:
        print(-1)
    

    t-=1
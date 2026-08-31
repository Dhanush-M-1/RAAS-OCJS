t = int(input())
while t:
    t -= 1
    n = int(input())
    arr = list(map(int,input().split()))
    i = 0
    # for i in range(n-2):
    if arr[i]+arr[i+1]<= arr[n-1]:
        print(i+1,i+2,n)
    else:
        print(-1)
    
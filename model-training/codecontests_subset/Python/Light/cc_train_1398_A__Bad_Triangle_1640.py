t=int(input())
while (t>0):
    n=int(input())
    arr=input().split()
    arr=[int(i) for i in arr]
    if (arr[0]+arr[1]>arr[n-1] and arr[1]+arr[n-1]>arr[0] and arr[n-1]+arr[0]>arr[1]):
        print(-1)
    else:
        print(1,2,n)
    t-=1
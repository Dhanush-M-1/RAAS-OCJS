a=int(input())
for i in range(0,a):
    b=int(input())
    arr=list(map(int,input().split()))
    if(arr[0]+arr[1]>arr[len(arr)-1]):
        print(-1)
    else:
        print(1,2,len(arr))
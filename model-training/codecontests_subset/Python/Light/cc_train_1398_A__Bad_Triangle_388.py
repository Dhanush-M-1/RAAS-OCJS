for t in range(int(input())):
    num=int(input())
    arr=list(map(int,input().split()))

    if arr[0]+arr[1]>arr[num-1]:
        print(-1)
    else:
        print(1,2,num)


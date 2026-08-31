for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    print(*[[1,2,n],[-1]][arr[0]+arr[1]>arr[n-1]])

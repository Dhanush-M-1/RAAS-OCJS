for t in range(int(input())):
    n=int(input())
    arr=[int(k) for k in input().split()]
    if arr[0]+arr[1]<=arr[-1]:
        print(1,2,n)
    else:
        print(-1)

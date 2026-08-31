for i in range(int(input())):
    n = int(input())
    arr = [int(x) for x in input().split()]
    arr.sort()
    if arr[0]+arr[1]<=arr[len(arr)-1]:
        print(1,2,len(arr))
    else:
        print(-1)

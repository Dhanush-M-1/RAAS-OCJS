for i in range(int(input())):
    n = int(input())
    arr = [i for i in map(int,input().split())]
    sorted(arr)
    if(arr[0]+arr[1]<=arr[n-1]):
        print(f"1 2 {n}")
    else:
        print(-1)


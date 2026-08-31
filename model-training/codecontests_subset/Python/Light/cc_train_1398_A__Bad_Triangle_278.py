t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    print("-1" if arr[0]+arr[1]>arr[n-1] else f"1 2 {n}")
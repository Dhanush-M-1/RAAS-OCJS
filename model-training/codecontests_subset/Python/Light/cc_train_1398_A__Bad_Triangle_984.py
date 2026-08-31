T = int(input())
for _ in range(T): 
    n = int(input())
    arr = list(map(int, input().split()))
    if arr[0]+arr[1] <= arr[n-1]: 
        print(f"{1} {2} {n}")
    else: 
        print(-1)
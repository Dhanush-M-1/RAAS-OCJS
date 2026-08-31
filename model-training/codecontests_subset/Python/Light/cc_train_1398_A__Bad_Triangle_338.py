import sys

n = int(sys.stdin.readline())
for _ in range(n):
    m = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    if arr[0]+arr[1] <= arr[-1]:
        print(f"1 2 {len(arr)}")
    else:
        print("-1")
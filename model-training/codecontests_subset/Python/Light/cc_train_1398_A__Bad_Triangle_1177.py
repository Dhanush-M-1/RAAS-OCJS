
import sys
 
tc = int(sys.stdin.readline())
for _ in range(tc):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    find = False
    if arr[-1] >= arr[0] + arr[1]:
        print(1,2,n)
    else:
        print(-1)
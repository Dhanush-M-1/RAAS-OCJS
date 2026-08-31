import sys
import os.path  # =========================================================================
if(os.path.exists('in.txt')):
    sys.stdin = open("in.txt", "r")
    sys.stdout = open("out.txt", "w")
# =============================================================================================
for _ in range(int(input())):
    n = int(input())
    li = list(map(int, input().split()))
    l = sorted(li)
    if(l[0] + l[1] > l[-1]):
        print(-1)
    else:
        print(1, 2, n)

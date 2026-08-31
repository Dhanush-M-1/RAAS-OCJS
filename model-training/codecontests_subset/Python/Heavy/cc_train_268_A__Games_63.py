import sys
import os.path  # =========================================================================
if(os.path.exists('in.txt')):
    sys.stdin = open("in.txt", "r")
    sys.stdout = open("out.txt", "w")
# =============================================================================================
# for _ in range(int(input())):
n = int(input());li = [];li2 = [];ans = 0 
for i in range(n):
    b, c = map(int, input().split());li.append(b);li2.append(c)
for i in range(n):
    for j in range(n):
        if li[i] == li2[j]:ans += 1
print(ans)
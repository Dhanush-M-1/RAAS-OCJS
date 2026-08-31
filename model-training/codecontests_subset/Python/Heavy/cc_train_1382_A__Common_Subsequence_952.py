from sys import stdin, stdout
INF=1e11
import sys
def get_int(): return int(stdin.readline().strip())
def get_ints(): return map(int,stdin.readline().strip().split()) 
def get_array(): return list(map(int,stdin.readline().strip().split()))
def get_string(): return stdin.readline().strip()
def op(c): return stdout.write(c)
from collections import defaultdict 
for _ in range(int(stdin.readline())):
    n,m=get_ints()
    a=get_array()
    b=get_array()
    ans=[]
    for i in range(n):
        for j in range(m):
            if a[i]==b[j]:
                ans.append(a[i])
                break
    if len(ans)>=1:
        print("YES")
        print(1,ans[0])
    else:
        print("NO")
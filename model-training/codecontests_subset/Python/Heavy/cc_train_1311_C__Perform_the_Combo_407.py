from sys import *
from collections import Counter
input = lambda:stdin.readline()

int_arr = lambda : list(map(int,stdin.readline().strip().split()))
str_arr = lambda :list(map(str,stdin.readline().split()))
get_str = lambda : map(str,stdin.readline().strip().split())
get_int = lambda: map(int,stdin.readline().strip().split())
get_float = lambda : map(float,stdin.readline().strip().split())


mod = 1000000007
setrecursionlimit(1000)

for _ in range(int(input())):
    n,m = get_int()
    s = str(input())[:-1]
    arr = int_arr()

    lst = [0]*(n+1)
    lst[n] = 1
    for i in range(m):
        lst[arr[i]-1] += 1
 
    for i in range(n-1,-1,-1):
        lst[i] += lst[i+1]

    res = [0]*26
    for i in range(len(s)):
        res[ord(s[i])-97] += lst[i]

    print(*res)

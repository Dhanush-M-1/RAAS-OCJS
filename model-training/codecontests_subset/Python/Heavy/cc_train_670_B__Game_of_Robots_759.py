from sys import *
from itertools import *
input = lambda:stdin.readline()
 
int_arr = lambda : list(map(int,stdin.readline().strip().split()))
str_arr = lambda :list(map(str,stdin.readline().split()))
get_str = lambda : map(str,stdin.readline().strip().split())
get_int = lambda: map(int,stdin.readline().strip().split())
get_float = lambda : map(float,stdin.readline().strip().split())
 
 
mod = 1000000007
setrecursionlimit(1000)
 
n,k = get_int()
arr = int_arr()

lst = [0] * n
dic = {}
prev = 0
for i in range(1,n+1):
    lst[i-1] = i + prev
    prev = lst[i-1]
    dic[lst[i-1]] = i-1

for i in range(n):
    if lst[i] == k:
        print(arr[dic[lst[i]]])
        break
    if lst[i] > k:
        val = k - lst[i-1]
        print(arr[val -1])
        break

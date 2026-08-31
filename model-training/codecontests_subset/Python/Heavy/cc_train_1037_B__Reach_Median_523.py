from collections import Counter,defaultdict,deque

read = lambda : list(map(int,input().split()))
getinfo = lambda grid: print(list(map(print,grid)))
p = lambda x: print(x,end=" ")

mod = 10**9 + 7
inf = float('inf')

def solve(a,s):
    res = 0
    index = len(a) // 2
    if a[index] == s:
        return 0
    elif a[index] < s:
        while index < n and a[index] < s:
            res += s-a[index]
            index += 1
        return res
    else:
        while index >=0 and a[index] > s:
            res += a[index] - s
            index -= 1
        return res


n,s = read()
a = read()
a.sort()
print(solve(a,s))


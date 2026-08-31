from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################

n, k = minput()
a = linput()
mn = float('inf')
d = [[] for _ in range(200001)]

for i in range(n):
    temp = a[i]
    c = 0
    while temp:
        d[temp].append(c)
        c+=1
        temp//=2

for i in range(200001):
    if len(d[i]) >= k:
        d[i].sort()
        mn = min(mn, sum(d[i][:k]))

print(mn)

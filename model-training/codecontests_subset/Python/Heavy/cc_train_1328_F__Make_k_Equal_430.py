from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################

n, k = minput()
a = linput()
a.sort()
mn = float('inf')
p = []
for i in range(n):
    temp = a[i]
    while temp:
        p.append(temp)
        temp//=2

p = list(set(p))
for i in range(len(p)):
    c = p[i]
    op = []
    for j in range(n):
        cnt = 0
        temp = a[j]
        while temp > c:
            temp //= 2
            cnt += 1
        if temp == c:
            op.append(cnt)
    if len(op)>=k:
        op.sort()
        mn = min(mn, sum(op[:k]))


c = 0
for i in range(k):
    while a[i]:
        a[i]//=2
        c+=1
mn = min(mn, c)
print(mn)
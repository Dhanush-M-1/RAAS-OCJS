import sys
sys.setrecursionlimit(20000000)
input = sys.stdin.readline
n,m = map(int,input().split())
a = list(map(int,input().split()))
for i in range(n):
        a[i]-=1
b = [list(map(int,input().split())) for i in range(m)]
na = a[-1]
g = [set() for i in range(n)]
nani = set()
for i,j in b:
        i-=1
        j-=1
        g[i].add(j)
        if j == na:
                nani.add(i)
ans = 0
usi = set()
for i in range(n-2,-1,-1):
        if a[i] in nani:
                if len(g[a[i]]) == len(g[a[i]].union(usi)):
                        ans += 1
                else:
                        usi.add(a[i])
        else:
                usi.add(a[i])
print(ans)
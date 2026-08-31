import bisect
import sys
class ft:
    def __init__(self,n):
        self.a = [0]*(200000)
        self.n = n
    def qry(self,r):
        ret = 0
        while r>=0:
            ret+=self.a[r]
            r=(r&(r+1))-1
        return ret
    def upd(self,i,v):
        while i<self.n:
            self.a[i]+=v
            i=(i|(i+1))
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
n = int(input())
x = list(map(int,input().split()))
v = list(map(int,input().split()))
f0 = ft(n)
f1 = ft(n)
a1 = [[] for _ in range(n)]
for i in range(n):
    a1[i].append(x[i])
    a1[i].append(v[i])
a1.sort()
v.sort()
ans = 0
for i in range(n):
    p = bisect.bisect_left(v,a1[i][1])
    ans+=(f0.qry(p)*a1[i][0])-(f1.qry(p));
    f0.upd(p,1)
    f1.upd(p,a1[i][0])
print(ans)
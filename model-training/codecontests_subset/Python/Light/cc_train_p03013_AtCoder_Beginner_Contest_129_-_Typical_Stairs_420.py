M=10**9+7
import sys
f=sys.stdin.readline
n,m=map(int,f().split())
s,t=0,1
u=0 if m<1 else int(f())
for i in range(n):
  if i==u-1:
    s,t=t,0
    try: u=int(f())
    except: pass
  else: s,t=t,(s+t)%M
print(t)
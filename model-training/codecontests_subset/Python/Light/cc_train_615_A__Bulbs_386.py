n,m=input().split()
n=int(n)
m=int(m)
t=[]
for i in range(n):
    l=list(map(int, input().split()))
    l.remove(l[0])
    t+=l
s=set()
for i in range(len(t)):
    s.add(t[i])
s=list(s)
if len(s)==m:
    print('YES')
else:
    print('NO')
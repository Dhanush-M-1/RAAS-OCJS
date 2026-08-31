cnt = lambda s, x: s.count(x)
ii = lambda: int(input())
si = lambda: input()
f = lambda: map(int, input().split())
dgl = lambda: list(map(int,input()))
il = lambda: list(map(int, input().split()))
n=ii()
l1=sorted(il())
l2=sorted(il())
l3=sorted(il())
x,y=0,0
for i,j in zip(l1,l2):
    if i!=j:
        x=i
        break
    x=l1[-1]
print(x)
for i,j in zip(l2,l3):
    if i!=j:
        y=i
        break
    y=l2[-1]
print(y)


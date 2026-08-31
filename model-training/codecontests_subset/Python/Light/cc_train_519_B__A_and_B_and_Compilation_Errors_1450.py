a=int(input())
b=list(map(int,input().split()))
c=list(map(int,input().split()))
d=list(map(int,input().split()))
e=0
f=0
g=0
def sam(r,m):
    for i in r:
        m+=i
    return m
e=sam(b,e)
f=sam(c,f)
g=sam(d,g)
print(e-f)
print(f-g)

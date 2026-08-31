import sys
input=sys.stdin.readline
def check(a,b,x,m):
    a=[(i+x)%m for i in a]
    a.sort()
    return a==b
from collections import Counter as C
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
a.sort()
b.sort()
l=a[0]
aa=C(a)
bb=C(b)
cc=aa[a[0]]
#print(cc)
ll=[]
for i in bb:
    if(bb[i]==cc):
        ll.append(i)
#print(ll)
mi=10000000000000000000
for i in ll:
    if(i>=l):
        x=i-l
        if(check(a,b,x,m)):
           mi=min(i-l,mi)
    else:
        x=m-l+i
        if(check(a,b,x,m)):
           mi=min(x,mi)
print(mi)
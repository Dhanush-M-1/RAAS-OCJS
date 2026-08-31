from collections import Counter
n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
d=Counter(a)-Counter(b)
for k,v in d.items():
    print(k)
d=Counter(b)-Counter(c)
for k,v in d.items():
    print(k)

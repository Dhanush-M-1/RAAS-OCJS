a,b=[int(x) for x in input().split()]
d=0
out=0
while a>0:
    a-=1
    d+=1
    out+=1
    if out%b==0:
        a+=1
if a==0:
    print(d)
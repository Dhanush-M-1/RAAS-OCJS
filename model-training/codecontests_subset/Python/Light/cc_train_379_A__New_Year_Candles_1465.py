a,b=map(int,input().split())
v=0
c=0
while a>0:
    v+=1
    a-=1
    c+=1
    if c==b:
        c=0
        a+=1
print(v)
    
a, b=map(int,input().split())
t=0
s=0
while a>0:
    t+=1
    s+=1
    a-=1
    if s==b:
        a+=1
        s=0
print(t)
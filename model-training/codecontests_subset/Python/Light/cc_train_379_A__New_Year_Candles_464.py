a,b=list(map(int,input().split()))
s=0
while a-b>=0:
    t=a//b
    a-=t*b-t
    s+=t*b
print(s+a)
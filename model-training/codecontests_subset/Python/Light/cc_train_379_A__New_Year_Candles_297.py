a,b=map(int,input().split())
s=0
c=0
while a > 0:
    a-=1
    c+=1
    if c >= b:
        c-=b
        a+=1
    s+=1
print(s)
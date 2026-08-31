a,b=map(int,input().split())
s=0
bn=0
while a!=0:
    a-=1
    bn+=1
    s+=1
    if bn==b:
        bn=0
        a+=1
print(s)

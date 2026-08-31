a,b=map(int,input().split(" "))
res=0
sub=0
while a>0:
    a-=1
    res+=1
    sub+=1
    if sub==b:
        a+=1
        sub=0
print(res)

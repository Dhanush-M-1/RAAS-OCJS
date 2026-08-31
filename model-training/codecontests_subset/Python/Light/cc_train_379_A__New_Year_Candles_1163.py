a,b=map(int,input().split())
hor=0
sgor=0
while a>0:
    hor+=1
    a-=1
    sgor+=1
    if sgor==b:
        a+=1
        sgor-=b
print(hor)
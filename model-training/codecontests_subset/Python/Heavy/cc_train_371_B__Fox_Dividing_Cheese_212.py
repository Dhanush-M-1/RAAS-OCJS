d1={2:0,3:0,5:0}
d2={2:0,3:0,5:0}
a,b=map(int,input().split())
if a%2==0:
    c=0
    while a%2==0:
        c+=1 
        a=a//2 
    d1[2]=c 
if a%3==0:
    c=0 
    while a%3==0:
        c+=1 
        a=a//3 
    d1[3]=c 
if a%5==0:
    c=0 
    while a%5==0:
        c+=1 
        a=a//5 
    d1[5]=c 
if b%2==0:
    c=0
    while b%2==0:
        c+=1 
        b=b//2
    d2[2]=c 
if b%3==0:
    c=0
    while b%3==0:
        c+=1 
        b=b//3
    d2[3]=c 
if b%5==0:
    c=0
    while b%5==0:
        c+=1 
        b=b//5 
    d2[5]=c 
#print(d1,d2)
if a!=b: 
    print(-1)
else:
    cnt=0 
    for i in [2,3,5]:
        cnt+=abs(d1[i]-d2[i]) 
    print(cnt)
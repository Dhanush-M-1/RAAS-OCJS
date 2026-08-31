a,b=map(int,input().split())
used=0;hours=0
while a!=0:
    a+=-1
    hours+=1
    used+=1
    if used==b:
        a+=1
        used=0
print(hours)

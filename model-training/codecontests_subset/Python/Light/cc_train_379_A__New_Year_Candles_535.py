a,b=map(int,input().split())
time=0
out=0
while a!=0:
    a-=1
    time+=1
    out+=1
    if out==b:
        out=0
        a+=1
print(time)
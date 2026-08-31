a,b=map(int,input().split())
c=0;time=0
while a!=0:
    time+=a
    a,c=(a+c)//b,(a+c)%b
print(time)
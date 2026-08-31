a,b=map(int,input().split())
i=1
while(i<=a):
    if(i%b==0):
        a+=1
    i+=1
print(a)
a,b=map(int,input().split())
sum=0
while(a>0):
    sum+=1
    a-=1
    if(sum%b==0):
        a+=1
print(sum)
    


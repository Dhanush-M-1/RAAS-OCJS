a,b=map(int,input().split())
i=0
while a!=0:
    a-=1
    i+=1
    if i%b==0:
        a+=1
print(i)
    
    
    

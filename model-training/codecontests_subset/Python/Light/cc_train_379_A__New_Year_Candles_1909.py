a,b=map(int,input().split())
i=0
while a>0:
    i+=1
    a-=1
    
    if i%b==0:
        a+=1
    
print(i)

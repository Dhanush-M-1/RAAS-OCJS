a,b=map(int,input().split())
c=0
k=0
while a!=0:
    a-=1
    k+=1
    c+=1
    if k%b==0:
        a+=1
        
print(c)
    

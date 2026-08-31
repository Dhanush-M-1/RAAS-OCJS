x=list(map(int,input().split()))
n=0
while x[0]!=n:
    n+=1
    if n%x[1]==0:
        x[0]=x[0]+1
        
 
 
print(n)
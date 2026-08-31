import sys
n,p=map(int,sys.stdin.readline().split())
m=[]
x=list(map(int,sys.stdin.readline().split()))
for j in range(0,len(x)):
    
    if(p%x[j]==0):
        s=p//x[j]
        m.append(s)
print(min(m))
        
    
        
            
        
        
        
        
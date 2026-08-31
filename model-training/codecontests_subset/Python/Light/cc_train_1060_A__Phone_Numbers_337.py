t=0
n=int(input())
m=input()

for i in range(len(m)): 
    if (m[i]=='8'):
        t=t+1
if (t>=n/11):
    print("%d"%int(n//11))
else:
    print("%d"%t)
        
        
        
    



n,m = map(int,input().split())

bulb = {i :0 for i in range(1,m+1)}

for i in range(n) :
    
    x = list(map(int,input().split()))
    
    for j in range(1,len(x)) :
        
        bulb[x[j]] = 1 
flag = 1       
for i in range(1,m+1):
    
    if bulb[i]==0 :
        print("NO")
        
        flag = 0 
        break
        
if flag :
    print("YES")
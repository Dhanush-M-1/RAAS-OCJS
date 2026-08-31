import math 

n,k=map(int,input().split())
a=list(map(int,input().split()))
a.sort()

steps = [0]*200005 
count = [0]*200005 
ans = []
# 
#for i in range(n):
#    count[a[i]]+=1 

for i in range(n):
    x=a[i]
#    if count[x] == k :ans.append(steps[x])
#    print(math.floor(math.log2(a[i])+2))
    for j in range(math.floor(math.log2(a[i])+2)):
        if count[x] == k :
            ans.append(steps[x])

         
         
        count[x]+=1
        steps[x]+=j
        x=x//2
for i in range(200005):
    if count[i]==k:
        ans.append(steps[i])
        

print(min(ans))
      
            
            
        
        
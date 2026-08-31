n,m = map(int,input().split())
one=[]
two=[]
both=[]
for i in range(n):
    t,a,b = map(int,input().split())
    if a==1 and b==1:
        both.append(t)
    elif a==1 and b==0:
        one.append(t)
    elif a==0 and b==1:
        two.append(t)
one.sort()
two.sort()
both.sort()        
if len(one)+len(both)<m:
    print(-1)
    exit()
elif len(two)+len(both)<m:
    print(-1)
    exit()            
ans=0
i=j=k=aa=bb=s=0
while s<m:
    if i==len(one) or j==len(two):
        ans+=both[k]
        k+=1
    elif k==len(both):
        ans+=one[i]+two[j]
        i+=1
        j+=1    
    elif one[i]+two[j]<=both[k]:
        ans+=one[i]+two[j]
        i+=1
        j+=1
    else:
        ans+=both[k]
        k+=1
    s+=1
print(ans)    



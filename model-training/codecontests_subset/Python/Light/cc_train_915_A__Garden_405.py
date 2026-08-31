l=list(map(int,input().split(' ')))
t=list(map(int,input().split(' ')))
c=0
for i in range(l[0]):
    if t[i]<=l[1] and l[1]%t[i]==0 and t[i]>c:
        c=t[i]

print(int(l[1]/c))        
    

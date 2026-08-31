n=int(input())
x=input()
ans=0
m={'A':0,'I':0,'F':0}
for i in x:
    m[i]+=1
for i in x:
    if i=='A' :
        if m['I']==0:
            ans+=1
    elif i=='I':
        if m[i]==1:
            ans+=1
print(ans)
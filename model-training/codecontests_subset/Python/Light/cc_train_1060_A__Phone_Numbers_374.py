n=int(input())
s=input()
c=0
for i in s:
    if i=='8':
        c+=1
ans=min(c,n//11)
print(ans)
        

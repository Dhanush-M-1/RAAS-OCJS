n,k=map(int,input().split())
a=input().split()
for i in range(n):
    a[i]=int(a[i])
a.sort()
a1=[]
for j in range(n):
    a1.append(a[j])
b=[0 for i in range(2*(10**5)+1)]
b1=[0 for i in range(2*(10**5)+1)]
for j in range(n):
    q=0
    while a[j]:
        if(b[a[j]]<k):
            b[a[j]]+=1
            b1[a[j]]+=q
        a[j]=a[j]//2  
        q+=1
c=[]        
for j in range(2*(10**5)+1):
    if(b[j]==k):
        c.append(b1[j])
count=0    
#print(c)
#print(a1)
for i in range(k):
    while a1[i]!=0:
        count+=1
        a1[i]=a1[i]//2
#print(count,min(c))        
if(len(c)>0):print(min(count,min(c)))  
else:print(count)
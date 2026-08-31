x=int(input())
arr=[1]
while x!=1:
    if x%2==0:
        arr.append(2)
        x//=2
        continue
    for i in range(3,10**6+9,2):
        if x%i==0:
            arr.append(i)
            x//=i
            break
    else:
        arr.append(x)
        x=1
        
while arr.count(1)!=0:
    del(arr[arr.index(1)])
    
arr.sort()
d=list(set(arr))
p=[]
for i in range(len(d)):
    p.append(d[i]**arr.count(d[i]))
    
d=[]
for i in range(len(p)+1):d.append(0)
q1=10**12;q2=10**12
while d[-1]!=1:
    a=1;b=1
    for i in range(len(d)-1):
        if d[i]==1:
            a*=p[i]
        else:
            b*=p[i]
    if max(a,b)<max(q1,q2):
        q1=a;q2=b
    d[0]+=1
    for i in range(len(d)-1):
        if d[i]==2:
            d[i]=0
            d[i+1]+=1
        else:
            break
print(q1,q2)
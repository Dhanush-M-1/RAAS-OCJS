n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
da={}
db={}
for i in range(n):
    if da.get(a[i],0)==0:
        da[a[i]]=1
    else:
        da[a[i]]+=1
    if db.get(b[i],0)==0:
        db[b[i]]=1
    else:
        db[b[i]]+=1
count=0
l1=sorted(set(a))
l2=sorted(set(b))
min1=100000000000000
while count<len(l1):
    flag=True
    if l1[0] > l2[count]:
        k = m - l1[0] + l2[count]
    else:
        k = l2[count] - l1[0]
    for i in range(len(l1)):
        if da[l1[i]]!=db[l2[(i+count)%len(l1)]] or (l1[i]+k)%m!=l2[(i+count)%len(l1)]:
            flag=False
            break
    if flag==True:
        if l1[0] > l2[count]:
            k=m - l1[0] + l2[count]
        else:
            k=l2[count] - l1[0]
        if k<min1:
            min1=k
        break
    count+=1
print(min1)
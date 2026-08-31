n,m=map(int,input().split())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
s1,s2,flag,ans=set(),[],0,[]
for i in b:
    s2.append(set())
    for j in a:
        if i>=j: 
            s1.add(i-j)
            s2[len(s2)-1].add(i-j)
        else:
            s1.add(i+m-j)
            s2[len(s2)-1].add(i+m-j)
for i in s1:
    for j in s2:
        if i in j:
            flag=1
            continue
        else:
            flag=0
            break
    if flag==1:
        ans.append(i)
b.sort()
realans=[]
for i in ans:
    new=a[:]
    for j in range(len(new)):
        new[j]=(new[j]+i)%m
    new.sort()
    if new==b:
        realans.append(i)
print(min(realans))
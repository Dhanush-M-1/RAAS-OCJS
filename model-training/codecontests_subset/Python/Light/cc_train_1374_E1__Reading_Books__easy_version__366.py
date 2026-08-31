n,k=list(map(int,input().strip().split()))
list1=[]
list2=[]
list12=[]
list0=[]

for _ in range(n):
    x,y,z=list(map(int,input().strip().split()))
    if y==1 and z==1:
        list12.append(x)
    elif y==1:
        list1.append(x)
    elif z==1:
        list2.append(x)
    

list1.sort()
list2.sort()

loop=min(len(list1),len(list2))
for i in range(loop):
    list12.append(list1[i]+list2[i])

list12.sort()
if len(list12)<k:
    print(-1)
else:
    ans=0
    for i in range(k):
        ans+=list12[i]
    print(ans)
        




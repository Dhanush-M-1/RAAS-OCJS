n,m=[int(i) for i in input().split()]
l=[]
while n:
    n-=1
    lst=[]
    lst=input().split()
    del lst[0]
    for i in range(len(lst)):
        l.append(int(lst[i]))
l=list(set(l))
c=0
for i in range(1,m+1):
    if i in l:
        c+=1
if c==m:
    print("YES")
else:
    print("NO")
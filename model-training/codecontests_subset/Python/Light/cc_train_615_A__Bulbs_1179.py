n,m=map(int,input().split())
lst=[]
for i in range(n):
    l=list(map(int,input().split()))
    for j in range(1,l[0]+1):
        lst.append(l[j])
lst=set(lst)
if len(list(lst))==m:
    print("YES")
else:
    print("NO")

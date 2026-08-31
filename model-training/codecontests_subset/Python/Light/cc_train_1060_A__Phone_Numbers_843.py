n=int(input())
l=[int(x) for x in input()].count(8)
n-=l
res=min(n//10,l)
l-=res
n-=res*10
if l!=0:
    res+=(l+n)//11
print(res)

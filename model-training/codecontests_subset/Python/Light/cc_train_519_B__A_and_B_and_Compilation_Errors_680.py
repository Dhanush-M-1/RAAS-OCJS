n=int(input())
a=[int(x) for x in input().split()]
a.sort()
b=[int(x) for x in input().split()]
b.sort()
c=[int(x) for x in input().split()]
c.sort()
ans1=0
ans2=0
for i in range (len(b)):
    if(a[i]!=b[i]):
        ans1=int(a[i])
        break
if(ans1==0):
    ans1=int(a[len(a)-1])
for i in range (len(c)):
    if(b[i]!=c[i]):
        ans2=int(b[i])
        break
if(ans2==0):
    ans2=int(b[len(b)-1])
print(ans1)
print(ans2)



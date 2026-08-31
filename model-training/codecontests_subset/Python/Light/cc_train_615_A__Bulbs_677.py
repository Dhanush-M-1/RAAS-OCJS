n,m=list(map(int,input().split()))
c=[]
i=0
while i<n:
    a=list(map(int,input().split()))
    c+=a[1:]
    i+=1
i=0
c.sort()
c=set(c)
sum1=0
for x in c:
    if True:
        sum1 += x
sum2=m*(m+1)//2
if sum2==sum1:
    print("YES")
else:
    print("NO")

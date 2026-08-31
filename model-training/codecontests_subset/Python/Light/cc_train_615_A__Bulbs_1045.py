n,m=map(int,input().split())
numlist=[]
i=0
while i<n:
    lis=list(input().split())
    numlist+=lis[1:]
    i+=1
total=len(numlist)
j=0
for j in range(total):
    numlist[j]=int(numlist[j])
    j+=1
numlist=set(numlist)
t=int(1)
while t<=m:
    if int(t) not in numlist:
        print("NO")
        break
    else:
        t+=1
if t>m:
    print("YES")
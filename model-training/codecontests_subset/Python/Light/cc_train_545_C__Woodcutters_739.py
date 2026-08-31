n=int(input())
xhpair=[]
for i in range(n):
    s=[int(x) for x in input().split()]
    x=s[0]
    h=s[1]
    xhpair.append((x,h))

ncount=2
pre=xhpair[0][0]
for k in range(1,n-1):
    i=xhpair[k]
    j=xhpair[k+1]
    if i[0]-pre>i[1]:
        ncount+=1
        pre=i[0]
    elif i[0]+i[1]<j[0]:
        ncount+=1
        pre=i[0]+i[1]
    else:
        pre=i[0]
if n>1:
    print(ncount)
else:
    print(1)

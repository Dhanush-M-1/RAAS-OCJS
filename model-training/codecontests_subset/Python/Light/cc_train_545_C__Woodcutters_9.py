n=int(input())
if n==1:
	print(1)
else:
    a=[]
    b=[]
    num=2
    for i in range(n):
        p,q=[int(x) for x in input().split()]
        a.append(p)
        b.append(q)
    for i in range(1,n-1):
        if a[i]-a[i-1]>b[i]:
            num+=1
        elif a[i+1]-a[i]>b[i]:
            a[i]+=b[i]
            num+=1
    print(num)
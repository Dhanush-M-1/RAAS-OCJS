n,k = map(int,input().split())
x= []
y= []
z = []
for _ in range(n):
    t,a,b = map(int,input().split())
    if a==1 and b==1:
        x.append(t)
    elif a==1 and b==0:
        y.append(t)
    elif a==0 and b==1:
        z.append(t)
if len(x)>=k or (k - len(x)<=len(y) and k - len(x)<= len(z)):
    x.sort()
    y.sort()
    z.sort()
    i = 0
    j = 0
    ans = 0
    while i +j<k:
        if i<len(x) and j<len(y) and j<len(z):
            if x[i]<y[j]+z[j]:
                ans = ans+x[i]
                i =i+1
            else:
                ans = ans+y[j]+z[j]
                j=j+1
        elif i<len(x):
            ans = ans+x[i]
            i = i+1
        elif j<len(y) and j<len(z):
            ans = ans+y[j]+z[j]
            j = j+1
    print(ans)        
else:
    print('-1')

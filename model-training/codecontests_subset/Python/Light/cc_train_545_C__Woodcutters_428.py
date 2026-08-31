n=int(input())
A=[]
for i in range(n):
    B=[int(x)for x in input().split()]
    A.append(B)
num=1
pre=A[0][0]
for i in range(1,n-1):
    a=A[i]
    b=A[i+1]
    if a[0]-pre>a[1]:
        num+=1
        pre=a[0]
        continue
    if a[0]+a[1]<b[0]:
        num+=1
        pre=a[0]+a[1]
        continue
    pre=a[0]
if n==1:
    print(1)
else:
    print(num+1)

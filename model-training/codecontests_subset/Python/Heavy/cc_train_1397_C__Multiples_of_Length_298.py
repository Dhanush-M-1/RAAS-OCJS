n=int(input())
a=list(map(int,input().split()))
b=[]
if n==1:
    print("1 1")
    print(n-a[0]%n)
    a[0]=a[0]+n-a[0]%n
    print("1 1")
    print(n-a[0]%n)
    a[0]=a[0]+n-a[0]%n
    print("1 1")
    print(-a[0])
else:    
    for k in range(n-1):
        b.append((a[k]%n)*(n-1))
        a[k]=a[k]+(a[k]%n)*(n-1)
    print("1",n-1)
    print(' '.join(map(str,b)))
    print(n,n)
    print(n-a[n-1]%n)
    a[n-1]=a[n-1]+n-a[n-1]%n
    print("1",n)
    for k in range(n):
        a[k]=-1*a[k]
    print(' '.join(map(str,a)))    
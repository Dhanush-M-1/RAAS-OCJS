from sys import stdin,stdout
nmbr=lambda:int(stdin.readline())
lst=lambda:list(map(int, stdin.readline().split()))
for _ in range(1):#nmbr()):
    n=nmbr()
    a=lst()
    if n==1:
        print(1,1)
        print(-a[0])
        print(1,1)
        print(0)
        print(1,1)
        print(0)
        continue
    print(1,n)
    for i in range(n):
        stdout.write(str(-n*a[i]) + ' ')
    print()
    print(1,n-1)
    for i in range(n-1):
        stdout.write(str((n-1)*a[i])+' ')
    print()
    print(n,n)
    print(a[-1]*(n-1))


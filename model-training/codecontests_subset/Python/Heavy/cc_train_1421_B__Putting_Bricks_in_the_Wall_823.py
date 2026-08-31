t = int(input())
for i in range(t):
    l = []
    n = int(input())
    for i in range(n):
        z = [i for i in input().split()]
        l.append(z)
   
    a = int(l[0][0][1])
    b = int(l[1][0][0])
    c = int(l[n-2][0][n-1])
    d = int(l[n-1][0][n-2])
    
    if a==b==c==d:#3
        print(2)
        print(1,2)
        print(2,1)
    if a==1 and b==0 and c==0 and d==0:#
        print(1)
        print(2,1)
    if a==0 and b==1 and c==0 and d==0:#
        print(1)
        print(1,2)
    if a==1 and b==1 and c==0 and d==0:#2
        print(0)
    if a==0 and b==0 and c==1 and d==1:#1
        print(0)
    if a==0 and b==0 and c==1 and d==0:#
        print(1)
        print(n,n-1)
    if a==0 and b==0 and c==0 and d==1:#
        print(1)
        print(n-1,n)
    if a==0 and b==1 and c==0 and d==1:
        print(2)
        print(2,1)
        print(n-1,n)
    if a==0 and b==1 and c==1 and d==1:
        print(1)
        print(2,1)
    if a==0 and b==1 and c==1 and d==0:
        print(2)
        print(2,1)
        print(n,n-1)
    if a==1 and b==0 and c==0 and d==1:
        print(2)
        print(2,1)
        print(n,n-1)
    if a==1 and b==0 and c==1 and d==1:
        print(1)
        print(1,2)
    if a==1 and b==0 and c==1 and d==0:
        print(2)
        print(1,2)
        print(n,n-1)
    if a==1 and b==1 and c==0 and d==1:
        print(1)
        print(n,n-1)
    if a==1 and b==1 and c==1 and d==0:
        print(1)
        print(n-1,n)
        

    
    

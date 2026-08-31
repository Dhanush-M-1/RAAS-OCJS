t=int(input())
for var in range(0,t):
    nm=[]
    nm=input().split()
    for k in range(2):
        n=int(nm[0])
        m=int(nm[1])
    a=[]
    a=input().split()
    for i in range(0,n):
        a[i]=int(a[i])
    b=[]
    b=input().split()
    for j in range(m):
        b[j]=int(b[j])
    if n>=m:
        flag1=0
        for i in range(len(a)):
            if a[i] in b:
                print("YES")
                print(1,end=" ")
                print(a[i])
                flag1=1
                break
        if flag1==0:
            print("NO")
    elif m>=n:
        flag2=0
        for i in range(len(b)):
            if b[i] in a:
                print("YES")
                print(1,end=" ")
                print(b[i])
                flag2=1
                break
        if flag2==0:
            print("NO")
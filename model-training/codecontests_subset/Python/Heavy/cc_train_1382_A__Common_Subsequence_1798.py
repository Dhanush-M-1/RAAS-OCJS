t=int(input())
for _ in range(t):
    n,m=list(map(int,input().split()))
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    if(n==m==1):
        if(a[0]==b[0]):
            print("YES")
            print(1,a[0])
        else:
            print("NO")
    else:
        t1=0
        flag=0
        for i in range(n):
            if(a[i] in b):
                flag=1
                t1=i
                break
        if(flag==1):
            print("YES")
            print(1,a[t1])
        else:
            print("NO")
        

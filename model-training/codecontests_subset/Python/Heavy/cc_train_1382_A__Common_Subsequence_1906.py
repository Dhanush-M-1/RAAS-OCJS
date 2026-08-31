t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    k=0
    if(n==1 and m==1):
        if(a[0]==b[0]):
            print("YES")
            print("1",a[0])
        else:
            print("NO")
    else:
        for x in range(n):
            for y in range(m):
                if(a[x]==b[y]):
                    k=a[x]
                    break
        if(k==0):
            print("NO")
        else:
            print("YES")
            print("1",k)
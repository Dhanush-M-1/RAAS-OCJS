import copy
t=int(input())
for _ in range(t):
    n=int(input())
    a=[]
    b=[]
    flag=1
    for i in range(n):
        m,l=map(int,input().split())
        if(l>m):
            flag=0
        else:
            a.append(m)
            b.append(l)
    if(flag==1):
        c=copy.deepcopy(a)
        d=copy.deepcopy(b)
        c.sort()
        d.sort()
        if(a == c and b == d):
            for j in range(1,n):
                if(a[j]-a[j-1] < b[j]-b[j-1]):
                    print("NO")
                    flag=3
                    break
            if(flag==1):
                print("YES")
        else:
            print("NO")
    else:
        print("NO")

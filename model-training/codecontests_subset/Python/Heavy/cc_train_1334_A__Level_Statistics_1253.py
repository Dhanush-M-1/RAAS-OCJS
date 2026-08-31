t=int(input())

while (t>0):
    n=int(input())
    if n==1:
        p,c=map(int,input().split())
        if p<c:
            print("NO")
        else:
            print("YES")
        t-=1
    else:
        p=[]
        c=[]
        for i in range (n):
            p1,c1=map(int,input().split())
            p.append(p1)
            c.append(c1)
        p_curr=p[0]
        c_curr=c[0]
        if p_curr<c_curr:
            print("NO")
            t-=1
            continue
        f=0
        for i in range (1,n):
            if abs(p[i-1]-p[i])< abs(c[i-1]-c[i]):
                print("NO")
                f=1
                break
            if (p[i-1]>p[i]):
                print("NO")
                f=1
                break
            if (c[i-1]>c[i]):
                print("NO")
                f=1
                break
            if p[i]<c[i]:
                print("NO")
                f=1
                break
        if f==0:
            print("YES")
        t-=1
        
        
        

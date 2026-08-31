import sys
def exgcd(a,b,l):
    if b==0:
        l[0]=1
        l[1]=0
        return a
    d=exgcd(b,a%b,l)
    t=l[0]-a//b*l[1]
    l[0]=l[1]
    l[1]=t
    return d
def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)
n,p,w,d=map(int,input().split(" "))
l=[0,0]
if p%gcd(w,d)!=0:
    print(-1)
else:
    m=exgcd(w,d,l)
    l[0]=p*l[0]//m
    l[1]=p*l[1]//m
    if l[0]<0 and l[1]<0:
        print(-1)
        sys.exit()
    if l[0]>=0 and l[1]>=0 and l[1]+l[0]<=n:
        print(l[0],end=" ")
        print(l[1],end=" ")
        print(n-l[0]-l[1])
        sys.exit()
    if l[0]+l[1]>n and w==d:
        print(-1)
        sys.exit()
    if p==0:
        print(0,end=" ")
        print(0,end=" ")
        print(n)
        sys.exit()
    else:
        if l[0]<0 and l[1]>=0:
            sum=l[0]*m//d-1
            l[1]+=w*sum//m
            l[0]-=sum*d//m
            if l[1]<0:
                print(-1)
                sys.exit()
        if l[1]<0 and l[0]>=0:
            sum=l[1]*m//(-w)+1
            l[0]-=d*sum//m
            l[1]+=w*sum//m
            if l[0]<0:
                print(-1)
                sys.exit()
        if l[0]+l[1]<=n and l[0]>=0 and l[1]>=0:
            print(l[0],end=" ")
            print(l[1],end=" ")
            print(n-l[0]-l[1])
            sys.exit()
        else:
            num,tag=(w-d)//m,0
            cnt=(n-l[0]-l[1])//num
            for i in range(cnt-100,cnt+100):
                res1=int(l[0]-d*i//m)
                res2=int(l[1]+w*i//m)
                if res1+res2<=n and res1>=0 and res2>=0:
                    print(res1,end=" ")
                    print(res2,end=" ")
                    print(n-res1-res2)
                    sys.exit()
            print(-1)
        


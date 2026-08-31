x=int(0)
y=int(0)

def exgcd(a,b):
    global x,y
    if b==0:
        x=1
        y=0
        return a
    d=exgcd(b,a%b)
    tmp=x
    x=y
    y=tmp-a//b*y
    return d

n,p,w,d=map(int,input().split())

if p==0:
    print('0 0 ',end='')
    print(n)
else:
    tmp=exgcd(w,d)
    if p%tmp!=0:
        print('-1')
    else:
        d1=d//tmp
        d2=w//tmp
        x*=(p//tmp)
        x=(x%d1+d1)%d1
        y=(p-w*x)//d
        if y<0:
            print('-1')
        else:
            k=(n-x-y)//(d1-d2)
            if k>=0 and (n-x-y)%(d1-d2)!=0:
                k+=1
            kmin=-x//d1
            if x%d1!=0:
                kmin+=1
            k=max(k,kmin)
            kmax=y//d2
            if k>kmax:
                print('-1')
            else:
                x=x+k*d1
                y=y-k*d2
                print(x,y,n-x-y,end=' ')
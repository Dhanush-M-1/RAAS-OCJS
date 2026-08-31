def f(n):
    a=0
    b=0
    while n!=1:
        if n%2!=0 and n%3!=0:
            return (False,0,0)
        else:
            if n%2==0:
                n//=2
                a+=1
            if n%3==0:
                n//=3
                b+=1
    if n==1:
        return (True,a,b)
for _ in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
    else:
        t=f(n)
        if t[0]==False:
            print(-1)
        else:
            a=t[1]
            b=t[2]
            if a==b:
                print(a)
            if a>b:
                print(-1)
            if a<b:
                print(2*b-a)
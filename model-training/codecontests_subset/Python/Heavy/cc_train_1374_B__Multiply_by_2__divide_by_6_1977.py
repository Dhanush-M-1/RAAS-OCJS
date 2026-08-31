t=int(input())
for i in range(t):
    n=int(input())
    if n==1:
        print(0)
    else:
        b=0
        c=0
        x=0
        y=0
        while b==0:
            if n%2==0:
                n=n//2
                x+=1
            else:
                b+=1
        while c==0:
            if n%3==0:
                n=n//3
                y+=1
            else:
                c+=1
        if n!=1:
            print(-1)
        else:
            if x>y:
                print(-1)
            else:
                print(y+(y-x))
# cook your dish here
for _ in range(int(input())):
    n=int(input())
    z=n
    f=0
    if n==1:
        print(0)
    else:
        c2,c3=0,0
        while n%2==0:
            n//=2
            c2+=1
        while n%3==0:
            n//=3
            c3+=1
        #print(c2,c3)
        if c3==c2 :
            if z==pow(6,c3):
                print(c3)
            else:
                print(-1)
        elif c3>c2:
            x=c3-c2
            z*=pow(2,x)
            if z==pow(6,c3):
                print(x+c3)
            else:
                print(-1)
        else:
            print(-1)
            
            
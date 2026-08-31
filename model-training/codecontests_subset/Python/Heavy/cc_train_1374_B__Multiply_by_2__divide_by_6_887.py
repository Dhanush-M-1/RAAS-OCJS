t=int(input())
for i in range(t):
    n=int(input())
    if n==1:
        print(0)
    elif n%3!=0:
        print(-1)
    else:
        b=0
        while n%3==0:
            n=n/3
            b+=1
        if n==1:
            print(2*b)
        else:
            if n%2!=0:
                print(-1)
            else:
                a=0
                while n%2==0:
                    n=n/2
                    a+=1
                if n!=1:
                    print(-1)
                else:    
                    if a<=b:
                        print(2*b-a)
                    else:
                        print(-1)
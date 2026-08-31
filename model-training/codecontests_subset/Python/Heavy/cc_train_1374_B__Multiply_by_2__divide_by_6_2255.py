def divide_by_3(a):
    b=0
    while a%3 == 0:
        a=a/3
        b+=1
    return (a,b)

def divide_by_2(a):
    b=0
    while a%2 == 0:
        a=a/2
        b+=1
    return (a,b)


t=int(input())
while t>0:
    n= int(input())
    if (n%3 != 0 and n!=1):
        print(-1)

    else:
        (n,a) = divide_by_3(n)
        (n,b) = divide_by_2(n)

        if n ==1:
            if b>a:
                print(-1)
            else:
                if a==b:
                    print(a)
                else:
                    print(a-b+a)
        else:
            print(-1)
    t=t-1

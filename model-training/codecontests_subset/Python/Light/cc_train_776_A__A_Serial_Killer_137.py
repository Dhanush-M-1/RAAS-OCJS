a,b=input().split()
n=int(input())
print(a+' '+b)
for i in range (n):
    c,d=input().split()
    if (a==c):
        print(b+' '+d)
        a=b;b=d;
    else:
        if (a==d):
            print(b+' '+c)
            a=b;b=c;
        else:
            if (b==c):
                print(a+' '+d)
                a=a;b=d;
            else:
                if (b==d):
                    print(a+' '+c)
                    a==a;b==c;

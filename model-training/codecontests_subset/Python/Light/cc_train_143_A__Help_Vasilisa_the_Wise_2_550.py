a,b=map(int,input().split())
c,d=map(int,input().split())
e,f=map(int,input().split())
for i1 in range(1,10):
    for i2 in range(1,10):
        for i3 in range(1,10):
            for i4 in range(1,10):
                if i1!=i2 and i1!=i3 and i1!=i4 and i2!=i3 and i2!=i4 and i3!=i4:
                    if i1+i2==a and i3+i4==b and i1+i3==c and i2+i4==d and i1+i4==e and i2+i3==f:
                        print(i1,i2)
                        print(i3,i4)
                        exit(0)
print(-1)
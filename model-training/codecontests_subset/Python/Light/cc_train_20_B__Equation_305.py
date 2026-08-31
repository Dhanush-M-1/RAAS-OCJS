a,b,c = [int(x) for x in input().split()]

if a == 0 and b == 0 and c == 0:
    print(-1)
elif a == 0:
    if b == 0:
        print(0)
    else:
        print(1)
        print(-c/b)
else:
    disc = b**2 - 4*a*c
    denom = 2*a
    if disc == 0:
        print(1)
        print(-b/denom)
    elif disc < 0:
        print(0)
    else:
        print(2)
        if a > 0:
            print((-b-disc**0.5)/denom)
            print((-b+disc**0.5)/denom)
        else:
            print((-b+disc**0.5)/denom)
            print((-b-disc**0.5)/denom)
        



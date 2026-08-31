t = int(input())
for i in range(t):
    n = int(input())
    if n == 1:
        print(0)
    else:
        ost2 = 0
        ost3 = 0
        while n % 2 == 0:
            n //= 2
            ost2 += 1
        while n % 3 == 0:
            n //= 3
            ost3 += 1
        if ost3 < ost2 or n != 1:
            print(-1)
        elif ost3 == ost2:
            print(ost3)
        else:
            ans = ost2
            ost3-=ost2
            ans+=ost3
            ans+=ost3
            print(ans)



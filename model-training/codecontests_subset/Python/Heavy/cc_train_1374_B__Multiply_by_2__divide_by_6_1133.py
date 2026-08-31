t = int(input())
for i in range(t):
    a = int(input())
    if a == 1:
        print(0)
    else:
        ost2 = 0
        ost3 = 0
        while a % 2 == 0:
            a //= 2
            ost2 += 1
        while a % 3 == 0:
            a //= 3
            ost3 += 1
        if ost3 < ost2 or a != 1:
            print(-1)
        elif ost3 == ost2:
            print(ost3)
        else:
            ans = ost2
            ost3-=ost2
            ans+=ost3
            ans+=ost3
            print(ans)



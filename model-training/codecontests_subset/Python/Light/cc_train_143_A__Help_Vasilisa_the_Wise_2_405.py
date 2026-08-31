r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
hallado = True
for x3 in range(1,10):
    for x4 in range(1,10):
        if (r1 == d1 - x4 + d2 -x3) and (r2 == x3 + x4)and (c1== d1 - x4 + x3) and (c2 == d2 - x3 + x4) and (x3 != x4) and  (d1 - x4 != d2 - x3) and (d1 - x4 != x3) and (x4 != d2 - x3) and (d1 - x4 != x4) and ( x3!= d2 - x3) and (d2 - x3 >0) and (d1 - x4 >0) :
            print(d1-x4, d2-x3)
            print(x3, x4)
            hallado = False
            break
    if not hallado:
        break

if hallado:
    print(-1)
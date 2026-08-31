r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
lis = []
true = False
for i in range(1, 10):
    pa1 = 0
    pa2 = 0
    pb1 = 0
    lis.clear()
    lis.append(i)
    pa1 = d1 - i
    pa2 = c2 - i
    pb1 = r2 - i
    if  not pa1 in lis and pa1 > 0 and pa1 < 10:
        lis.append(pa1)
        if  not pa2 in lis and pa2 > 0 and pa2 < 10:
            lis.append(pa2)
            if  not pb1 in lis and pb1 > 0 and pb1 < 10:
                if pa2 + pb1 == d2 and pa1 + pb1 == c1 and pa1 + pa2 == r1:
                    print(pa1, pa2)
                    print(pb1, i)
                    true = True
                    break
if not true:
    print(-1)
        

# Wed Oct 14 2020 17:50:40 GMT+0300 (Москва, стандартное время)

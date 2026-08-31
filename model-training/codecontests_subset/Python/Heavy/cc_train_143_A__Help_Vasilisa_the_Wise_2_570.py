r1, r2 = map(int,input().split())
c1, c2 = map(int,input().split())
d1, d2 = map(int,input().split())
for x1 in range(1, 10):
    for x2 in range(1, 10):
        for y1 in range(1, 10):
            for y2 in range(1, 10):
                k = set([x1,x2,y1,y2])
                if len(k) != 4:
                    continue
                if r1 != x1 + x2:
                    continue
                if r2 != y1 + y2:
                    continue
                if c1 != x1 + y1:
                    continue
                if c2 != x2 + y2:
                    continue
                if d1 != x1 + y2:
                    continue
                if d2 != y1 + x2:
                    continue
                print(x1,x2)
                print(y1,y2)
                exit()
print(-1)
# Thu Oct 08 2020 20:55:27 GMT+0300 (Москва, стандартное время)

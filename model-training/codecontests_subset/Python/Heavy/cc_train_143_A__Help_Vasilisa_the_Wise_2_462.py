r1 , r2 = map(int, input().split())
c1 , c2 = map(int, input().split())
d1 , d2 = map(int, input().split())
x = 1
for x00 in range(1,10):
    for x01 in range(1,10):
        if (x00==x01):
            continue
        for x10 in range(1,10):
            if( (x10 == x00) | (x10 == x01) ):
                continue
            for x11 in range(1,10):
                if((x11 == x00) | (x11 == x10) | (x11 == x01)):
                    continue
                if((x00+x01 == r1)&(x10+x11 == r2)&(x00+x10 == c1)&(x01+x11 == c2)&(x00+x11 == d1)&(x01+x10 == d2)):
                    print(x00,x01)
                    print(x10,x11)
                    x = 0
                    break
if (x != 0):
    print(-1)
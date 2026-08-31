r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
for tl in range(1, 10):
    for tr in range(1, 10):
        for bl in range(1, 10):
            for br in range(1, 10):
                
                if tl + tr == r1 and bl + br == r2 and tl + bl == c1 and tr + br == c2 and tl + br == d1 and tr + bl == d2 and len({tl, tr, bl, br}) == 4:
                    print(tl, tr)
                    print(bl, br) 
                    exit()
print(-1)
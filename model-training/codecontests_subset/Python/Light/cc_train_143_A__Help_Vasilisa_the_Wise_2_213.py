from collections import Counter
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
c = 0
for i in range(1,10):
    for j in range(1, 10):
        for k in range(1, 10):
            for l in range(1, 10):
                if i+j == r1 and k+l == r2:
                    if i+k == c1 and j+l == c2:
                        if i+l == d1 and j+k == d2:
                            if len(Counter([i,j,k,l])) == 4:
                                print(f'{i} {j}\n{k} {l}')
                                c = 1
if c != 1:
    print(-1)

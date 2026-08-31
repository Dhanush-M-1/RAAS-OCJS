"""
    author - Sayan Bose
    date - 29.01.2020
    Brooklyn 99 is love!
"""
from itertools import permutations

r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

c = list(permutations([i for i in range(1, 10)], 4))

for i in c:
    t1, t2, t3, t4 = i
    if t1 + t2 == r1 and t3 + t4 == r2 and t1 + t3 == c1 and t2 + t4 == c2 and t1 + t4 == d1 and t2 + t3 == d2:
        print(t1, t2)
        print(t3, t4)
        exit()
print(-1)




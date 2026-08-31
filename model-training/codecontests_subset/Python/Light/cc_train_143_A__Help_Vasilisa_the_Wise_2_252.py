from itertools import permutations
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
for a, b, c, d in permutations(range(1, 10), 4):
    if a + b == r1 and c + d == r2 and a + c == c1 and b + d == c2 and a + d == d1 and c + b == d2:
        print(a, b)
        print(c, d)
        exit()
print(-1)

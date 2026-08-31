p = input()
n = int(input())

c1 = 0
c2 = 0
for i in range(n):
    w = input()
    c1 += 1 if w[0] == p[1] or w == p else 0
    c2 += 1 if w[1] == p[0] or w == p else 0

print("NO" if c1 == 0 or c2 == 0 else "YES")

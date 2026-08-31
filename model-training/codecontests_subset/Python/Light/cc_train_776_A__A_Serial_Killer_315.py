p = input().split()
n = int(input())

print(" ".join(p))
for i in range(n):
    a, b = input().split()
    p[p.index(a)] = b
    print(" ".join(p))

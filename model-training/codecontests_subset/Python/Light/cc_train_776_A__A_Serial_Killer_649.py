I = input
s = set(I().split())
print(*s)
for _ in range(int(I())):
    d, n = I().split()
    s = s - {d} | {n}
    print(*s)
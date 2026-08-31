password = input()
n = int(input())
p = []
c = 0
for i in range(n):
    p.append(input())
for i in range(n):
    s = p[i]
    if s[::-1] == password or s == password:
        c = 1
        break
    for j in range(1, n):
        t = p[j]
        if password in s+t or password in t+s:
            c = 1
        elif t[::-1] == password or t == password:
            c = 1
print("YES" if c == 1 else 'NO')
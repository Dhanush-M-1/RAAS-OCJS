def find_error(m, n):
    m.sort()
    n.sort()
    for i in range(len(n)):
        if m[i] != n[i]:
            return m[i]

    return m[len(m) - 1]


i = int(input())

x = [0] * i
y = [0] * (i - 1)
z = [0] * (i - 2)

a = input()
x = [int(x) for x in a.split()]

b = input()
y = [int(x) for x in b.split()]

c = input()
z = [int(x) for x in c.split()]

print(find_error(x, y))
print(find_error(y, z))

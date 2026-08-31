n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]
a.sort()
b.sort()
b.append(0)
c.sort()
c += [0, 0]
for x, y in zip(a, b):
    if x != y:
        print(x)
        break
for x, y in zip(b, c):
    if x != y:
        print(x)
        break
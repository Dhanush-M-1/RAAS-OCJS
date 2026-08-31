a, b = map(int, input().split())
i = [int(a) for a in input().split()]

i.sort()
i.reverse()
for x in i:
    if b % x == 0:
        s = b // x
        break
print(s)

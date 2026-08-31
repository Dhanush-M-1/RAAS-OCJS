input()
e1 = [int(x) for x in input().split()]
e2 = [int(x) for x in input().split()]
e3 = [int(x) for x in input().split()]
e1.sort()
e2.sort()
e3.sort()
for x in e3:
    e1.remove(x)
    e2.remove(x)
for x in e2:
    e1.remove(x)
print(e1[0])
print(e2[0])

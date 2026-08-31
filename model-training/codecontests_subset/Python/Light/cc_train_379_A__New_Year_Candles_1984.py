a = input().split()
a, b = int(a[0]), int(a[1])
t, pot = 0, 0
for i in range(a):
    t += 1
    pot += 1
while pot // b != 0:
    t += 1
    pot -= b
    pot += 1
print(t)
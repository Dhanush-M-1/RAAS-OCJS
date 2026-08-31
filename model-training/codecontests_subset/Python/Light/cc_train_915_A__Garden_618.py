k = int(input().split()[1])
a = input().split()

for i in range(len(a)):
    a[i] = int(a[i])

for d in sorted(a, reverse=True):
    if k % d == 0:
        break

print (k // d)

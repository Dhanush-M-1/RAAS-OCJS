c = input().split()

n = int(c[0])
K = int(c[1])
a = input().split()

for b in range(len(a)):
    a[b] = int(a[b])
a.sort()

dead = 0
same = 0
last_dead = False
for j in range(len(a) - 1):
    i = j + 1
    if same > 0:
        if last_dead:
            dead += 1
        same -= 1
    else:
        while a[i] == a[j] and i < len(a) - 1:
            i += 1
            same += 1
        last_dead = False
        if a[i] <= a[j] + K and not a[i] == a[j]:
            dead += 1
            last_dead = True
print(len(a) - dead)
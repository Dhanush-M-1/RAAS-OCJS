line1 = input().split()
n = int(line1[0])
k = int(line1[1])
nr = []
b = []
count = 0
line2 = input().split()
for i in line2:
    nr.append(int(i))
    b.append(bool(1))
nr = sorted(nr)
i = 1
while i < n:
    if nr[i] - nr[i-1] <= k and nr[i] > nr[i-1]:
        b[i-1] = bool(0)
    i += 1
i = n - 1
while i > 0:
    while (i > 0) and (b[i]):
        i -= 1
    j = i
    while (j >= 0) and nr[j] == nr[i] and i > 0:
        b[j] = bool(0)
        j -= 1
    i = j
i = 0
while i < n:
    if (b[i]):
        count += 1
    i += 1
print(count)

from collections import Counter

def Compare(a, b):
    for i in a:
        if b[i] != a[i]:
            return False
    return True

n, m = [int(i) for i in input().split()]
min = m

a = [int(i) for i in input().split()]
comparator = a[0]

b = [int(i) for i in input().split()]
b = Counter(b)

for i in b:
    if comparator > i:
        diff = m - comparator + i
    else:
        diff = i - comparator
    c = Counter([(i + diff) % m for i in a])
    if diff < min and Compare(b, c):
        min = diff

print(min)
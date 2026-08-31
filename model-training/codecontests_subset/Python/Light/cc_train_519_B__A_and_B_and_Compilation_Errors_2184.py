from collections import Counter

n = int(input())

first = [int(c) for c in input().rstrip().split(' ')]
c1 = Counter(first)

second = [int(c) for c in input().rstrip().split(' ')]
c2 = Counter(second)

for k,v in c1.items():
    if v != c2[k]:
        print(k)
        break

third = [int(c) for c in input().rstrip().split(' ')]
c3 = Counter(third)

for k,v in c2.items():
    if v != c3[k]:
        print(k)
        break
from collections import Counter

int(input())
e1 = Counter(input().split())
e2 = Counter(input().split())
e3 = Counter(input().split())

print(next(iter(e1 - e2)))
print(next(iter(e2 - e3)))

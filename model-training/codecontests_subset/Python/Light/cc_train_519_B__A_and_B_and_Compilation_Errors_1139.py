from collections import Counter

n = int(input())
a = Counter(input().split())
b = Counter(input().split())
c = Counter(input().split())

e1 = list((a - b).keys())
e2 = list((b - c).keys())

print(' '.join(e1 + e2))

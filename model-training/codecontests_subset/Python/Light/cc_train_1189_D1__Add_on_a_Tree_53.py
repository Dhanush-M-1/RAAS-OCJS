from collections import Counter
n = int(input())
x = []
for _ in range(n-1):
    x.extend(input().split())
print('NO' if 2 in Counter(x).values() else 'YES')

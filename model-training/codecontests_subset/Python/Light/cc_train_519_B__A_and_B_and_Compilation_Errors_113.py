from collections import Counter
n = input()
a = Counter(input().split())
b = Counter(input().split())
c = Counter(input().split())
a.subtract(b)
b.subtract(c)
print(list(+a)[0])
print(list(+b)[0])
from collections import Counter
input()
a = Counter(input().split())
b = Counter(input().split())
c = Counter(input().split())
print(list(a-b)[0])
print(list(b-c)[0])
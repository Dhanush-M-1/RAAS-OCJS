from collections import Counter
a = int(input())
b = list(int(x) for x in input().split())
c = list(int(x) for x in input().split())
d = list(int(x) for x in input().split())

p = list((Counter(b) - Counter(c)).elements())
for i in p:
    print(i)
p = list((Counter(c) - Counter(d)).elements())
for i in p:
    print(i)
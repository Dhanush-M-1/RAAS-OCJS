from collections import Counter
n = input()
a = Counter(list(input().split()))
b = Counter(list(input().split()))
c = Counter(list(input().split()))
x = list(a - b)
y = list(b - c)
for i in x:
    print(i)
for i in y:
    print(i)
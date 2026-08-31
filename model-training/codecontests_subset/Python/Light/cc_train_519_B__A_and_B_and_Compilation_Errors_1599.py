from collections import Counter
input()
s = Counter()
for i in map(int, input().split()):
    s[i] += 1
n = Counter()
for i in map(int, input().split()):
    n[i] += 1
print(*(s-n))
s = n
n = Counter()
for i in map(int, input().split()):
    n[i] += 1
print(*(s - n), sep="\n")

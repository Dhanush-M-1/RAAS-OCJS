# A and B and Compilation Errors

from collections import Counter

n = input()
first = Counter(map(int, input().split()))
second = Counter(map(int, input().split()))
third = Counter(map(int, input().split()))

for k in first:
    if first[k] != second[k]:
        print(k)
        break

for k in second:
    if second[k] != third[k]:
        print(k)
        break

from collections import Counter

n = int(input())
first = Counter(map(int, input().split()))
second = Counter(map(int, input().split()))
third = Counter(map(int, input().split()))

for el in first:
    if el not in second or second[el] < first[el]:
        print(el)
        break

for el in second:
    if el not in third or third[el] < second[el]:
        print(el)
        break

# TODO https://codeforces.com/problemset/problem/805/A
def get_key(dict, value):
    for a, b in dict.items():
        if b == value:
            return a
from collections import Counter
l, r = [int(el) for el in input().split(' ')]
lst_1 = []
if l % 2 == 0 or r % 2 == 0:
    print(2)
elif l == r:
    print(l)
else:
    for num in range(l, r+1):
        for i in range(2, 4):
            if num % i == 0:
                lst_1.append(i)
    quantity = Counter(lst_1)
    print(get_key(quantity, max(quantity.values())))

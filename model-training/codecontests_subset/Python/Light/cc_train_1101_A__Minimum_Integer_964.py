from math import ceil
n = int(input())

for i in range(n):
    [l, r, d] = [int(j) for j in input().split()]
    if l>d:
        print(d)
    else:
        k = ceil(r/d)*d
        print(k+d if k==r else k)
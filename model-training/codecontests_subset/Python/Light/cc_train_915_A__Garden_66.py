from sys import stdin
from collections import defaultdict


n, k= [int(x) for x in input().split()]
a = {int(x) for x in input().split()}

ans = 0
for i in range(1, k + 1):
    if i in a and k % i == 0:
        ans = k // i

print(ans)
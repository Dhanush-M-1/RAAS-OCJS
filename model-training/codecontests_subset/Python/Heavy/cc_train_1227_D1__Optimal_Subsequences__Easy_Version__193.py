import itertools
import functools
from operator import itemgetter
def cmp(a, b):
    # 0 - descending, 1 - ascending
    # returns: -1, a before b;  1 b before a; 0 no difference
    if a[0] > b[0]:
        return -1
    elif a[0] < b[0]:
        return 1
    else:
        if a[1] < b[1]:
            return -1
        elif a[1] > b[1]:
            return 1
        else:
            return 0



n = int(input())
a = list(map(int, input().split()))
c = a[:]
c = list(zip(a, itertools.count(0)))
c = sorted(c, key=functools.cmp_to_key(cmp))
h = c[:]
m = int(input())

for i in range(m):
    k,pos = map(int, input().split())
    h = sorted(c[:k], key=itemgetter(1))
    print(h[pos-1][0])







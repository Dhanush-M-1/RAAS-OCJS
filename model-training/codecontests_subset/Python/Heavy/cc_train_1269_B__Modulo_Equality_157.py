from collections import Counter


def perm(d1, d2):
    k1 = sorted(d1.keys())
    k2 = sorted(d2.keys())
    init_offset = k2[0] - k1[0]
    if init_offset < 0:
        return False
    for i in range(len(k1)):
        if d1[k1[i]] != d2[k2[i]]:
            return False
        offset = k2[i] - k1[i]
        if offset != init_offset:
            return False
    return True


n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = dict(Counter(a))
d = dict(Counter(b))
while not perm(c, d):
    lowest = min(d.keys())
    d[lowest + m] = d[lowest]
    del d[lowest]
k1 = sorted(c.keys())
k2 = sorted(d.keys())
print(min(d.keys()) - min(c.keys()))

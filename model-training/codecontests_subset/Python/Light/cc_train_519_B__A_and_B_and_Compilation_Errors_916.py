from collections import Counter

input()
nsets = [Counter(map(int, input().split())) for _ in range(3)]

def diff(c1, c2):
    for k in c1:
        if c1[k] > 1 and c2[k] < c1[k]:
            return k
        if c1[k] == 1 and k not in c2:
            return k

for i in 0, 1:
    print(diff(nsets[i], nsets[i + 1]))


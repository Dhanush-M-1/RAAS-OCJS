from collections import Counter
n,*lst = open(0).read().split()
c = Counter(lst)
for s in ['AC','WA','TLE','RE']:
    print(f"{s} x {c[s]}")
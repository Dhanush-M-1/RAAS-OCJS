from collections import Counter
n = int(input())
c = Counter(input())
if '8' in list(c):
    print(min(n//11,c['8']))
else:
    print(0)
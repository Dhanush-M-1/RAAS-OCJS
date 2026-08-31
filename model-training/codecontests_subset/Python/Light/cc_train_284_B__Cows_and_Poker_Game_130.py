from collections import Counter
t = int(input())
arr= list(input())

c = Counter(arr)
if c['I']==0:
    res = c['A']
elif c['I']==1:
    res = 1
else:
    res = 0
print(res)

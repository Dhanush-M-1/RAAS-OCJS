from collections import Counter

n = int(input())

s = input()

c = Counter(s)

res = 0
for i in s:
    c[i] -= 1
    if i in 'AI':
        if c['I'] == 0:
            res += 1
    c[i] += 1
    
print(res)


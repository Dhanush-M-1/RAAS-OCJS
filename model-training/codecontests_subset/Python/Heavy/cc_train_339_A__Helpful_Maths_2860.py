# s = [ str(x) for x in input() if x != '+' ]

# for _ in range(len(s)):
#     for x in range(len(s) - 1):
#         if s[x + 1] < s[x]:
#             s[x + 1], s[x] = s[x], s[x + 1]

# print( '+'.join(s) )

# 186 мс 1200 КБ

from random import choice

s = [str(x) for x in input() if x != '+']

def index(arr):
    if len(arr) <= 1:
        return arr
    else:
        c = choice(arr)
        l, m, r = [], [], []

        for x in arr:
            if x < c: l.append(x)
            elif x > c: r.append(x)
            else: m.append(x)

        return index(l) + m + index(r)

s2 = index(s)
print('+'.join(s2))
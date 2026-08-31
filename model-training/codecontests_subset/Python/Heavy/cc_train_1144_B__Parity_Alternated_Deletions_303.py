import re, math, decimal, bisect, collections
def read(): return input().strip()
def iread(): return int(input().strip())
def viread(): return [int(_) for _ in input().strip().split()]
def round(n): return int(n + 0.5)

n = iread()
arr = sorted(viread())[::-1]
tot = sum(arr)
divd = [[], []]
for i in arr:
    divd[i % 2].append(i)
i = 0
s = 0
while i < min(map(len, divd)):
    s += divd[0][i] + divd[1][i]
    i += 1
if i >= len(divd[0]) and i < len(divd[1]):
    s += divd[1][i]
elif i >= len(divd[1]) and i < len(divd[0]):
    s += divd[0][i]
print(tot - s)

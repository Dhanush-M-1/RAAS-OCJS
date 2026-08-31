import sys
a = int(input())
y = 0
t = [int(x) for x in input().split()]
s = [int(x) for x in input().split()]
w = [int(x) for x in input().split()]
t.sort()
s.sort()
w.sort()
while t[y] == s[y]:
    y += 1
    if y >= len(t) or y >= len(s):
        break
print(t[y])
y = 0
while s[y] == w[y]:
    y += 1
    if y >= len(w) or y >= len(s):
        break
print(s[y])
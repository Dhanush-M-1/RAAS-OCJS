n = int(input())
s = input()
c = 0
for i in s:
    if i == '8': c -= -1
t = n // 11
print(min(c, t))
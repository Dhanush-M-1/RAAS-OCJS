n = int(input())
s = input()
m = int(n / 11)
c = 0
for i in s:
    if i == '8':
        c += 1
print(min(c, m))

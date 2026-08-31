n = int(input())
s = input()
eight, other = 0, 0
for i in range(len(s)):
    if s[i] == '8':
        eight += 1
    else:
        other += 1
res = 0
for i in range(1, 100):
    if i <= eight and (eight - i + other) >= i*10:
        res = i
    else:
        break
print(res)

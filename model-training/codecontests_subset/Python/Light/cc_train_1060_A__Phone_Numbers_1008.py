n = int(input())
s = input()

n8 = 0
for x in s:
    if x == '8':
        n8 += 1

print(min(n8, n // 11))
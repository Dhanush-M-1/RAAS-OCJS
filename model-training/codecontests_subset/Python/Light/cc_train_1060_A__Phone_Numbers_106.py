n = int(input())
s = input()
dg = list(s)

ans = 0
n8 = s.count('8')
while n8:
    n -= 11
    n8 -= 1
    if (n < 0):
        break
    ans += 1
print(ans)
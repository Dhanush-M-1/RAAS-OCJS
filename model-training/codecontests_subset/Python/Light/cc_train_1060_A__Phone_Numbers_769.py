n = int(input())
s = input()
ans = 0
for i in range(0, n) :
    if s[i] == '8' :
        ans = ans + 1
print(int(min(n / 11, ans)))

# 1060A => Phone Numbers
# https://codeforces.com/problemset/problem/1060/A

n = int(input())
digits = input()
if digits.count("8") == 0:
    print(0)
else:
    ans = 0
    temp = digits.count("8")
    for _ in range(temp):
        if n == 0 or n - 11 < 0:
            break
        n -= 11
        ans += 1
    print(ans)

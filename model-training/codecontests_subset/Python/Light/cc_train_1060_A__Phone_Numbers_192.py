# 1060A => Phone Numbers
# https://codeforces.com/problemset/problem/1060/A

n = int(input())
s = input()
print(min(s.count("8"), n // 11))

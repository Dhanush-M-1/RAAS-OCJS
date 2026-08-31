# https://codeforces.com/problemset/problem/776/A
# 900

iv = input().split()
n = int(input())

print(" ".join(iv))
for _ in range(n):
    k, r = input().split()
    iv.remove(k)
    iv.append(r)
    print(" ".join(iv))

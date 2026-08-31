# https://codeforces.com/problemset/problem/1060/A

n = int(input())
count = 0
if n < 11:
    print(0)
else:

    for i in input():
        if i == '8':
            count += 1
    print(min(count, n // 11))

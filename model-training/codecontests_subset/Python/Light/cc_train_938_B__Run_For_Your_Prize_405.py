n = int(input())

lst = list(map(int, input().split()))
ans = max([min(a - 1, 10 ** 6 - a) for a in lst])

print(ans)
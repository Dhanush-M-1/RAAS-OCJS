x = sorted(int(s) for s in input().split())
print('Yes' if sum(x[:-1]) == x[2] else 'No')
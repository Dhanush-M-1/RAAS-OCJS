m = sorted(map(int, input().split()))
print('Yes' if sum(m[:-1]) == m[-1] else 'No')

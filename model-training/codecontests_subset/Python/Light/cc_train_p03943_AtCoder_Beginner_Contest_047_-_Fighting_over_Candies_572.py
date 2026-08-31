n = [int(i) for i in input().split()]
print('Yes' if max(n) * 2 == sum(n) else 'No')

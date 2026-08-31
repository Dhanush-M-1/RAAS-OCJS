c = list(map(int,input().split()))
print('Yes' if max(c) == sum(c) - max(c) else 'No')
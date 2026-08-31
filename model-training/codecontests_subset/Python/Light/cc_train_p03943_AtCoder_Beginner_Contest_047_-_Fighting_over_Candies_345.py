A = tuple(map(int, input().split()))
print('Yes' if sum(A) == 2 * max(A) else 'No')
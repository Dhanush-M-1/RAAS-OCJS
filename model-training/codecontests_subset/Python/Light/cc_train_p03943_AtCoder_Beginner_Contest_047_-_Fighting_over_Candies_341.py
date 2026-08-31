A = [int(i) for i in input().split()]
print('Yes' if sum(A) == max(A) * 2 else 'No')
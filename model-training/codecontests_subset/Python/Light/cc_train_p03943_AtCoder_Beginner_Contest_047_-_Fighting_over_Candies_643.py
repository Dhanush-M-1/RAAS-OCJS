A = sorted(map(int, input().split()))
print('Yes' if A[2]==sum(A[:2]) else 'No')
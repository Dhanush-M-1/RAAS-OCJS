A = list(map(int,input().split()))
A.sort()
print('Yes' if A[2]-A[0] ==A[1] else 'No')

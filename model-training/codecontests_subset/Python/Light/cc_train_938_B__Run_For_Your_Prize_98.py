n = int(input())
A = [int(i) for i in input().split()]

A = [ min(A[i]-1, 10**6 - A[i]) for i in range(n)]
print(max(A))

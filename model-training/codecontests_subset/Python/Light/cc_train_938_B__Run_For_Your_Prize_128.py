n = int(input())
A = [int(x) for x in input().split()]

a = 1
b = 10**6

B = [min(e-a,b-e) for e in A]
print(max(B))

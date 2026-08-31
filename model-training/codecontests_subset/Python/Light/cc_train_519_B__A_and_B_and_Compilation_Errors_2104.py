n = int(input())

A = list(map(int, input().split(' ')[:n]))
B = list(map(int, input().split(' ')[:n-1]))
C = list(map(int, input().split(' ')[:n-2]))

print(sum(A)-sum(B))
print(sum(B)-sum(C))
# You lost the game.
n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))
A.sort()
B.sort()
C.sort()
k = 0
while k < n-1 and A[k] == B[k]:
    k += 1
print(A[k])
k = 0
while k < n-2 and C[k] == B[k]:
    k += 1
print(B[k])

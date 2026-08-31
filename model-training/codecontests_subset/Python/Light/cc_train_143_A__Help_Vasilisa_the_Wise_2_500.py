R = list(map(int, input().split()))
C = list(map(int, input().split()))
D = list(map(int, input().split()))
 
X = [(D[0] + C[0] - R[1]) // 2, (R[0] + C[1] - D[0]) // 2]
Y = [(D[1] + C[0] - R[0]) // 2, (R[1] + C[1] - D[1]) // 2]
if len(set(X + Y)) != 4 or any([True for i in X + Y if i>9 or i<=0]):
    print(-1)
else:
    print(*X)
    print(*Y)
 
# A new start
# Here in Tabas
# Waiting for the big news
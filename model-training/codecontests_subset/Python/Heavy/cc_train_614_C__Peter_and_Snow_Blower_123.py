import math

n, px, py = map(int, input().split())

points = []

for _ in range(n):
    x, y = map(float, input().split())
    points.append((x, y))

near = None
far = None

for i in range(-1, n - 1):
    A = points[i]
    B = points[i+1]
    C = (px, py)

    area = abs(A[0] * (B[1] - C[1]) + B[0] * (C[1] - A[1]) + C[0] * (A[1] - B[1])) / 2
    height = (2 * area) / math.hypot(A[0] - B[0], A[1] - B[1])
    A_dist = math.hypot(A[0] - C[0], A[1] - C[1])
    B_dist = math.hypot(B[0] - C[0], B[1] - C[1])
    dist = max(A_dist, B_dist)

    alpha = (B[0] - A[0]) * (C[0] - A[0]) + (B[1] - A[1]) * (C[1] - A[1])
    beta = (A[0] - B[0]) * (C[0] - B[0]) + (A[1] - B[1]) * (C[1] - B[1])

    if alpha < 0 or beta < 0:
        height = min(A_dist, B_dist)
    
    if near is None or height < near:
        near = height

    if far is None or dist > far:
        far = dist

inner = math.pi * (near ** 2)
outer = math.pi * (far ** 2)

print(outer - inner)

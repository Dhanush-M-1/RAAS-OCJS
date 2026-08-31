n = int(input())
coordinate = []
outcome = 2 if n >= 2 else 1

for _ in range(n):
    x, h = map(int, input().split())
    coordinate.append([x, h])
coordinate.sort(key=lambda y: y[0])

for i in range(1, n-1):
    if coordinate[i][0] - coordinate[i-1][0] > coordinate[i][1]:
        outcome += 1
    elif coordinate[i+1][0] - coordinate[i][0] > coordinate[i][1]:
        outcome += 1
        coordinate[i][0] += coordinate[i][1]

print(outcome)

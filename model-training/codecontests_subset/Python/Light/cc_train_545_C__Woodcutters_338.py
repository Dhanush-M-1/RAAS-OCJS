n = int(input())
X = []
H = []

for _ in range(n):
    [x, h] = [int(x) for x in input().split(' ')]
    X.append(x)
    H.append(h)

fell = 1
lastRight = X[0]

for i in range(1, n):
    if i == n - 1:
        fell += 1
    else:
        if lastRight < X[i] - H[i]:
            lastRight = X[i]
            fell += 1
        elif X[i+1] > X[i] + H[i]:
            lastRight = X[i] + H[i]
            fell += 1
        else:
            lastRight = X[i]

print(fell)
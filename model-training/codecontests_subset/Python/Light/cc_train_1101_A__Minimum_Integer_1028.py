N = int(input())
X = list()
for i in range(N):
    X.append(list(map(int, input().split())))
i = 0
while i < N:
    INTEGER = X[i][2]
    if INTEGER >= X[i][0] and INTEGER <= X[i][1]:
        INTEGER = X[i][1] + (X[i][2] - X[i][1] % X[i][2] if X[i][1] % X[i][2] != 0 else X[i][2])
    print(INTEGER)
    i += 1
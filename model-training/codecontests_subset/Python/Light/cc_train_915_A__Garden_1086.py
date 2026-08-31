X = list(map(int, input().split()))
Water = list(map(int, input().split()))
Water = sorted(Water, reverse=True)
for i in range(X[0]):
    if X[1] % Water[i] == 0:
        print(int(X[1] / Water[i]))
        exit()

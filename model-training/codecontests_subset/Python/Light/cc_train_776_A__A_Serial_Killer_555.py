Initial = list(input().split())
n = int(input())
print(*Initial, sep=" ")
for i in range(n):
    X = list(input().split())
    Initial[Initial.index(X[0])] = X[1]
    print(*Initial, sep=" ")

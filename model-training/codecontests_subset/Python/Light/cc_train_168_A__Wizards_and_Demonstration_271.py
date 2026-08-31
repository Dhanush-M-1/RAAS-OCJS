from math import ceil

X = list(map(int, input().split()))
Result = (ceil((X[0] * X[2]) / 100)) - X[1]
print(Result if Result > 0 else 0)

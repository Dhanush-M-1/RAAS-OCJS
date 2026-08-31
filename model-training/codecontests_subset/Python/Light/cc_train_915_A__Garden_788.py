k, n = map(int, input().split())
data = [int(i) for i in input().split()]

best_outcome = 0

for i in data:
    if n % i == 0 and i > best_outcome:
        best_outcome = i

print(n // best_outcome)

rounds = int(input())

for _ in range(rounds):
    n = int(input())
    values = list(map(int, input().split()))
    if values[0] + values[1] <= values[-1]:
        print(1, 2, len(values))
    else:
        print(-1)
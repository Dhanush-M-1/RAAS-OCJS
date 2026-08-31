rint = lambda: int(input())
rounds = rint()

for _ in range(rounds):
    data = [[int(c) for c in input().split()] for __ in range(rint())]
    time_seq = all([(data[i][0] <= data[i + 1][0] \
                and data[i][1] <= data[i + 1][1] \
                and data[i + 1][0] - data[i][0] >= data[i + 1][1] - data[i][1]) for i in range(len(data) - 1)])
    succ_prop = all([data[i][0] >= data[i][1] for i in range(len(data))])
    if time_seq and  succ_prop:
        print("YES")
    else:
        print("NO")

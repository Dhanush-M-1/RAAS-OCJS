import itertools

sum_to_sockets = [
    (0, 1),
    (2, 3),
    (0, 2),
    (1, 3),
    (0, 3),
    (1, 2)
]

sums = []
for _ in range(3):
    sums += list(map(int, input().split()))

for seq in itertools.permutations(range(1, 10), r=4):
    if all([seq[sum_to_sockets[i][0]] + seq[sum_to_sockets[i][1]] == sums[i]
            for i in range(6)]):
        print(str(seq[0]) + " " + str(seq[1]))
        print(str(seq[2]) + " " + str(seq[3]))
        break
else:
    print(-1)

n, m = map(int, input().split())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]

a.sort()
b.sort()

list_of_lists = [[i for i in a[start:] + a[0:start]] for start in range(n)]

min_candidate = float('inf')
for l in list_of_lists:
    # counter = 0
    if l[0] < b[0]:
        # candidate = b[0] - l[0]
        candidate = m - b[0]
    elif l[0] == b[0]:
        candidate = 0
    else:
        candidate = m - l[0] + b[0]

    counter = 0
    for ind, b_i in enumerate(b):
        if (l[ind] + candidate) % m == b_i:
            counter += 1

    if counter == n:
        min_candidate = candidate if candidate < min_candidate else min_candidate

print(min_candidate)


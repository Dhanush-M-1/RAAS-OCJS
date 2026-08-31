import string

data = input().rstrip().split()
t = int(data[0])
letters = list(string.ascii_lowercase)

all_vars = []

for u in range(t):
    data = input().rstrip().split()
    m, n = int(data[0]), int(data[1])

    data = input().rstrip().split()
    s = data[0]

    data = input().rstrip().split()
    ps = [int(p) for p in data]

    all_vars.append((m, n, s, ps))

def to_str(list):
    return " ".join([str(l) for l in list]) + ' '

for m, n, s, ps in all_vars:
    ps.sort(reverse=True)
    rr = [1,] * m
    counter = 0

    p_prev = ps[0]
    for i in range(n):
        if i != n-1:
            p_next = ps[i+1]
            if p_next == p_prev:
                continue
            for j in range(p_next, p_prev):
                rr[j] += i+1
            p_prev = p_next
        else:
            for j in range(0, p_prev):
                rr[j] += i+1

    result = {l: 0 for l in letters}
    for l, c in zip(s, rr):
        result[l] += c

    counts = [result[l] for l in letters]
    print(to_str(counts))








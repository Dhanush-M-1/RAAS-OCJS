from sys import stdin
inFile = stdin
tokens = []
tokens_next = 0


def next_str():
    global tokens, tokens_next
    while tokens_next >= len(tokens):
        tokens = inFile.readline().split()
        tokens_next = 0
    tokens_next += 1
    return tokens[tokens_next - 1]


def nextInt():
    return int(next_str())


T = nextInt()
for _ in range(T):
    n = nextInt()
    res = True
    p, c = 0, 0
    for i in range(n):
        curP, curC = nextInt(), nextInt()

        if curP < p:
            res = False

        diff_p = curP - p
        diff_c = curC - c
        if diff_c > diff_p or diff_c < 0:
            res = False

        p, c = curP, curC

    print('YES' if res else 'NO')

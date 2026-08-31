def read_tokens():
    return input().strip().split(' ')


def read_ints():
    return [int(s) for s in read_tokens()]


n, = read_ints()
s = input().strip()


def solve(s: str) -> str:
    hs = {}
    n = len(s)
    for i in range(n):
        for j in range(i+1, n):
            if j - i == 1:
                curr = s[i:j+1]
                if curr in hs:
                    hs[curr] += 1
                else:
                    hs[curr] = 1

    curr_k = None
    curr_v = -1
    for k,v in hs.items():
        if curr_v < v:
            curr_v = v
            curr_k = k
    return curr_k


print(solve(s))

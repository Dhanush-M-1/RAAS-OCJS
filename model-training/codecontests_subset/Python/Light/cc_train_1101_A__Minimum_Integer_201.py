n_queries = int(input())

for k in range(n_queries):
    r, l, d = list(map(int, input().split()))
    if d < r or d > l:
        print(d)
    else:
        print(((l // d)+1)*d)
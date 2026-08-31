n, m = map(int, input().split())
nab = [list(map(int, input().split())) for x in range(n)]
mab = [list(map(int, input().split())) + [x + 1] for x in range(m)]
print("\n".join(map(str, [min(mab, key=lambda x: abs(x[0] - a) + abs(x[1] - b))[-1] for a, b in nab])))
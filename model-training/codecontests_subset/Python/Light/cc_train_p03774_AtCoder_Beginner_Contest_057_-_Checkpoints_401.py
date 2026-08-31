N, M = map(int, input().split())
p_s = [list(map(int, input().split())) for _ in range(N)]
p_f = [list(map(int, input().split())) for _ in range(M)]
length = []

for s in p_s:
    for f in p_f:
        length.append(abs(s[0]-f[0]) + abs(s[1]-f[1]))
    print(length.index(min(length))+1)
    length = []
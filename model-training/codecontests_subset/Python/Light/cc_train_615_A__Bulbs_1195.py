n, m = map(int, input().split())
flags = [True] * m
for _ in range(n):
    for i in list(map(int, input().split()))[1:]:
        flags[i - 1] = False
print(['YES', 'NO'][any(flags)])

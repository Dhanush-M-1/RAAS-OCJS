n, k = map(int, input().split())
a = list(map(int, input().split()))

out = None
for ai in a:
    if k % ai == 0:
        if out is None:
            out = k // ai
        else:
            out = min(out, k // ai)
print(out)
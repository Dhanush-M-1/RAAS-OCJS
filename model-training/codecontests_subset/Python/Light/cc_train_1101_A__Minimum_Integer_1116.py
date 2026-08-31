nQ = int(input())
for q in range(nQ):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        print((r // d) * d + d)

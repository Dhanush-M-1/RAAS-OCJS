
def answer(l, r, d):
    if d < l:
        out = d
    else:
        amari = d - (r % d)
        out = r + amari
    return out


q = int(input())

for i in range(q):
    l, r, d = list(map(int, input().split(" ")))
    print(answer(l, r, d))
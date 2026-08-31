input()
def d():
    return list(map(int, input().split()))

r = sorted(d()), sorted(d()), sorted(d())
rb = [False, False]
rs = [r[0][-1], r[1][-1]]
for i in range(len(r[0])):
    if all(rb):
        break
    if not rb[1]:
        if i < len(r[2]) and r[1][i] != r[2][i]:
            rs[1] = r[1][i]
            rb[1] = True
    if not rb[0]:
        if i < len(r[1]) and r[0][i] != r[1][i]:
            rs[0] = r[0][i]
            rb[0] = True
print(*rs, sep = "\n")
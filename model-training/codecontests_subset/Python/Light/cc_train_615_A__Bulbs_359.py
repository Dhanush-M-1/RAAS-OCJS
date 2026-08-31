n, m = map(int, input().split())
table = [i for i in range(1, m+1)]
appeared = set([])
for _ in range(n):
    li = [int(i) for i in input().split()]
    if li[0] != 0:
        appeared |= (set(li[1:]) - set([0]))
print("YES" if len(appeared.symmetric_difference(set(table))) == 0 else "NO")

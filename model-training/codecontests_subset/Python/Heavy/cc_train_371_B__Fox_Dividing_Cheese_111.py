a, b = map(int, input().split())


def traverse(start, dictio, counter):
    if start in dictio and dictio[start] >= counter:
        return

    dictio[start] = counter

    if start % 5 == 0:
        traverse(start // 5, dictio, counter + 1)

    if start % 3 == 0:
        traverse(start // 3, dictio, counter + 1)

    if start % 2 == 0:
        traverse(start // 2, dictio, counter + 1)


dictA = dict()
dictB = dict()

traverse(a, dictA, 0)
traverse(b, dictB, 0)

ans = 9999999999999999

for v in dictA:
    if v in dictB:
        ans = min(ans, dictA[v] + dictB[v])

print(-1 if ans == 9999999999999999 else ans)

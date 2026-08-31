_, k = map(int, input().split())
arr = map(int, input().split())

number = dict()
A = list()

for n in arr:
    cnt = 0
    B = dict()
    while True:
        B[n] = cnt
        if n not in number:
            number[n] = 0
        number[n] += 1
        cnt += 1
        n //= 2
        if n == 0:
            break

    A.append(B)

best = 1_000_000_000

for n in range(0, 200_000):
    if n not in number or  number[n] < k:
        continue

    temp = []
    for m in A:
        if n not in m:
            continue

        temp.append(m[n])

    if len(temp) < k:
        break

    temp = sorted(temp)
    best = min(best, sum(temp[:k]))

print(best)


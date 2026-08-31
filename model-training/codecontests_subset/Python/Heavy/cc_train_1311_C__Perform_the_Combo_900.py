def combo(str, p):
    dct = {}
    for i in range(ord('a'), ord('z') + 1):
        dct[chr(i)] = 0

    cnt = [0] * len(str)
    for i in range(len(p)):
        cnt[p[i] - 1] += 1

    for i in range(len(str) - 1, 0, -1):
        cnt[i - 1] += cnt[i]

    for i in range(len(str)):
        dct[str[i]] += cnt[i] + 1

    for i in range(ord('a'), ord('z') + 1):
        print(dct[chr(i)], end=" ")
    print()


for i in range(int(input())):
    a, b = map(int, input().split())
    str = input()
    p = [int(j) for j in input().split()]
    combo(str, p)
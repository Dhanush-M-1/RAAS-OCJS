def test(a, k, pos):
    r = list(reversed(sorted(a.copy())))
    countLast = r[k-1]
    s = 0
    for i in range(k, len(r)):
        if r[i] == countLast:
            s += 1
    ans = []
    a = list(reversed(a))
    for i in range(len(a)):
        if a[i] > countLast or (a[i] == countLast and s == 0):
            ans.append(a[i])
        elif a[i] == countLast:
            s -= 1
    print(list(reversed(ans))[pos-1])

n = int(input())
a = list(map(int ,input().split()))
m = int(input())
for i in range(m):
    k, pos = map(int, input().split())
    test(a, k, pos)
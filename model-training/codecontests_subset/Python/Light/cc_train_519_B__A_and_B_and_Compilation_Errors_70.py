def diff(l1, l2):
    a1 = sorted(l1)
    a2 = sorted(l2)
    for i in range(len(a2)):
        if a1[i] != a2[i]:
            return a1[i]
    return a1[-1]

n = int(input())
I = lambda: list(map(int, input().split()))
a, b, c = I(), I(), I()
print(diff(a, b))
print(diff(b, c))
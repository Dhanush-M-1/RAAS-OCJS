input()
a = sorted([int(next) for next in input().split()])
b = sorted([int(next) for next in input().split()])
c = sorted([int(next) for next in input().split()])


def f(a, b):
    for i in range(len(b)):
        if a[i] != b[i]:
            return a[i]
    return a[len(a) - 1]

print(f(a, b))
print(f(b, c))
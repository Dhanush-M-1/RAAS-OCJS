def diff(m,n):
    for i in range(len(n)):
        if m[i] != n[i]:
            return m[i]
    return m[-1]

input()
a = sorted([int(x) for x in input().split()])
b = sorted([int(x) for x in input().split()])
c = sorted([int(x) for x in input().split()])

print(diff(a,b))
print(diff(b,c))
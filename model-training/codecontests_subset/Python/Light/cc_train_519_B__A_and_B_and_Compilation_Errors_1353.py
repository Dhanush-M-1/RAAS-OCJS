n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a1 = sorted(a)
b1 = sorted(b)
c1 = sorted(c)

if a1[:-1] == b1:
    print(max(a))
else:
    for i in range(len(b)):
        if a1[i] != b1[i]:
            print(a1[i])
            break

if b1[:-1] == c1:
    print(max(b))
else:
    for i in range(len(c)):
        if b1[i] != c1[i]:
            print(b1[i])
            break
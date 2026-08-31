n = int(input())
f = list(map(int, input().split()))

# n = 6
# f = [5, 1, 2, 4, 6, 3]

if n == 1:
    print(f[0], end='')
elif n == 2:
    print(min(f), end='')
else:
    odd, even = list(), list()
    for i in f:
        if i % 2 == 0: even.append(i)
        else: odd.append(i)

    even.sort()
    odd.sort()

    if len(even) == len(odd):
        print(0, end='')
        exit(0)

    minlen = min(len(even), len(odd)) + 1
    del even[-minlen:]
    del odd[-minlen:]

    print(sum(even) + sum(odd), end='')
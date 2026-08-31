n, k = list(map(int, input().split()))

p = [[], []]

for i in range(1, n + 1):

    c, t = map(int, input().split())

    p[t > 1].append((c, i))

if k > len(p[0]):

    l = k - len(p[0]) - 1

    print(sum(c for c, i in p[0]) / 2 + sum(c for c, i in p[1]))

    print('\n'.join('1 ' + str(i) for c, i in p[0]))

    print('\n'.join('1 ' + str(i) for c, i in p[1][: l]))

    print(len(p[1]) - l, ' '.join(str(i) for c, i in p[1][l: ]))

else:

    p[1].sort()

    p[0].sort(reverse = True)

    print(sum(c for c, i in p[0][: k - 1]) / 2 + sum(c for c, i in p[0][k - 1: ]) + sum(c for c, i in p[1]) - min(c for c, i in p[1] + p[0][k - 1: ]) / 2)

    print('\n'.join('1 ' + str(i) for c, i in p[0][: k - 1]))

    print(n - k + 1, ' '.join(str(i) for c, i in p[0][k - 1:]), ' '.join(str(i) for c, i in p[1]))



# Made By Mostafa_Khaled
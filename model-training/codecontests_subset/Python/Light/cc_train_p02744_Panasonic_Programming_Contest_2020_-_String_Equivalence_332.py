N = int(input())


def f(n, lst):
    if n == N:
        print(''.join(map(str, [chr(s + 97) for s in lst])))
    else:
        for i in range(max(lst) + 2):
            f(n + 1, lst + [i])


f(1, [0])

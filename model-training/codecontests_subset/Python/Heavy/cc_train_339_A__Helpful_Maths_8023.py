def helpful(s):
    L = []
    for i in range(len(s)):
        if not s[i] == '+':
            L.append(int(s[i]))
    L = quicksort(L)
    n = ''
    for things in L:
        n += '+' + str(things)
    return n[1:]


def quicksort(A):
    n = len(A)
    if n == 0:
        return A
    else:
        p = A[(n - 1) // 2]
        A_p = []
        A_n = []
        A_l = []
        for things in A:
            if things < p:
                A_n.append(things)
            elif things > p:
                A_p.append(things)
            else:
                A_l.append(things)
        return quicksort(A_n) + A_l + quicksort(A_p)


s = str(input())
print(helpful(s))

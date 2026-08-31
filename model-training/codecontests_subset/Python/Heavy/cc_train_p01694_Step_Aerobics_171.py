def ll(char, f):
    if char == "l":
        return not f
    return f


def rr(char, f):
    if char == "r":
        return not f
    return f


while True:
    N = int(input())
    if N == 0:
        break
    F = list(input().split())
    c = 0
    lFalg = False
    rFalg = False
    before = F[0]
    lFalg = ll(F[0][0], lFalg)
    rFalg = rr(F[0][0], rFalg)
    for i in range(1, len(F)):
        if not lFalg == rFalg:
            if not before[0] == F[i][0]:
                c += 1
        lFalg = ll(F[i][0], lFalg)
        rFalg = rr(F[i][0], rFalg)
        before = F[i]
    print(int(c))


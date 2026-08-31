def main():
    import sys
    input = sys.stdin.buffer.readline
    n, k = map(int, input().split())
    tab = [tuple(map(int, input().split())) for i in range(n)]

    tab.sort(reverse=True)
    A = [tab[i][0] for i in range(n) if tab[i][1] == 1 and tab[i][2] == 0]
    B = [tab[i][0] for i in range(n) if tab[i][1] == 0 and tab[i][2] == 1]
    AB = [tab[i][0] for i in range(n) if tab[i][1] == tab[i][2] == 1]

    count = 0
    ans = 0
    ab = 0
    apb = 0
    while(count < k):
        if len(AB) > 0:
            ab = AB[-1]
        else:
            ab = 10**10

        if len(A) > 0 and len(B) > 0:
            apb = A[-1] + B[-1]
        else:
            apb = 10**10

        if ab < apb:
            ans += ab
            if len(AB):
                AB.pop()
        else:
            ans += apb
            if len(A):
                A.pop()
            if len(B):
                B.pop()
        count += 1
    if ans >= 10**10:
        print(-1)
    else:
        print(ans)


main()

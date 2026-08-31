from sys import stdin, stdout


def main():
    n, k = map(int, stdin.readline().split())
    alice = []
    bob = []
    both = []
    ans = 0
    for i in range(n):
        t, a, b = map(int, stdin.readline().split())
        ans += t
        if a == 1 and b == 1:
            both.append(t)
        elif a == 1:
            alice.append(t)
        elif b == 1:
            bob.append(t)
        else:
            pass
    alice.sort()
    bob.sort()
    both.sort()
    #print(alice, bob, both)
    for i in range(1, len(alice)):
        alice[i] += alice[i - 1]
    for i in range(1, len(bob)):
        bob[i] += bob[i - 1]
    for i in range(1, len(both)):
        both[i] += both[i - 1]
    la, lbb, lbo = len(alice), len(bob), len(both)
    if la + lbo < k or lbb + lbo < k:
        ans = -1
    else:
        for i in range(lbo):
            rest = k - i - 1
            if rest > 0:
                if la >= rest and lbb >= rest:
                    ans = min(ans, both[i] + alice[rest - 1] + bob[rest - 1])
            else:
                ans = min(ans, both[i])
        if la >= k and lbb >= k:
            ans = min(ans, alice[k - 1] + bob[k - 1])
    stdout.write(str(ans))
    stdout.write('\n')
    return


if __name__ == '__main__':
    main()
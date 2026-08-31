
INF = float('inf')


def tc():
    n, k = map(int, input().split())
    books = [tuple(map(int, input().split())) for _ in range(n)]
    alice, bob, both = [], [], []

    for t, a, b in books:
        if a and b:
            both.append(t)
        elif a:
            alice.append(t)
        elif b:
            bob.append(t)

    alice.sort()
    bob.sort()
    for a, b in zip(alice, bob):
        both.append(a + b)
    both.sort()

    # if len(bob) > len(alice):
    #     leftover = bob[-(len(bob) - len(alice)):]
    # elif len(bob) < len(alice):
    #     leftover = alice[-(len(alice) - len(bob)):]
    # else:
    #     leftover = []

    if len(both) < k:
        print(-1)
    else:
        print(sum(both[:k]))


tc()

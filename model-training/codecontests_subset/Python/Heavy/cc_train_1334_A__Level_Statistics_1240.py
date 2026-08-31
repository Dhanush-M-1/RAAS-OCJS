import sys

readline = sys.stdin.readline
flush = sys.stdout.flush

T = int(readline())

for t in range(1, T + 1):
    N = int(readline())
    # H = [int(_) for _ in readline().split()]
    # H = [readline().split() for _ in range(N)]

    attempts = successes = 0
    ans = 'YES'

    for i in range(N):
        line = readline().split()
        # print(line)
        a, s = int(line[0]), int(line[1])

        if not(a >= attempts and s >= successes and (a-attempts) >= (s-successes)):
            ans = 'NO'
            while i < N-1:
                i += 1
                readline()
            break

        attempts, successes = a, s


    # print("Case #%d: %d" % (t, ans))
    print(ans)
import sys
input = sys.stdin.readline

def main():
    n, k = map(int, input().split())

    a = []
    b = []
    whole = []

    for _ in range(n):
        t, x, y = map(int, input().split())

        if x + y == 2:
            whole.append(t)

        elif x + y == 1:
            if x:
                a.append(t)

            else: b.append(t)

    a.sort()
    b.sort()

    for x, y in zip(a, b):
        whole.append(x + y)

    whole.sort()

    if len(whole) < k:
        print('-1')

    else:
        print(sum(whole[:k]))

main()

def better(a):
    # if sorted
    if a == ''.join(sorted(a)):
        return a

    a, n = list(a), len(a)

    for i in range(n):
        ans = -1

        for j in range(i+1, n):
            if a[i] <= a[j]:
                continue

            if ans == -1 or a[ans] >= a[j]:
                ans = j

        if ans != -1:
            tmp = a[ans]
            a[ans] = a[i]
            a[i] = tmp
            break

    return ''.join(a)


def run(a, b):
    if a < b:
        return a

    a = better(a)
    if a < b:
        return a
    else:
        return "---"


def main():
    N = int(input())
    for i in range(N):
        print(run(*input().strip().split()))


main()
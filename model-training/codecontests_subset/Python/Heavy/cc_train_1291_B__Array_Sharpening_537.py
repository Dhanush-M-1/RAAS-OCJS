def calc(a):
    if len(a) == 1:
        return 'Yes'
    start = 0
    found = True
    for i, n in enumerate(a):
        if i > n:
            start = i - 1
            found = False
            break
    if found:
        return 'Yes'
    for i in range(start, len(a)):
        if len(a) - i - 1 > a[i]:
            return 'No'
    return 'Yes'


if __name__ == '__main__':
    N = int(input())
    cases = []
    for _ in range(N):
        _ = input()
        c = list(map(int, input().split()))
        cases.append(c)
    for c in cases:
        print(calc(c))
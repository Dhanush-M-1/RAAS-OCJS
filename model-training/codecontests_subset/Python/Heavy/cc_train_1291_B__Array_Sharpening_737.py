def one():
    return int(input())


def two():
    return map(int, input.split())


def l():
    return list(map(int, input.split()))


def st():
    return input()


for i in range(one()):
    input()
    a = list(map(int, input().split()))
    pik = len(a)
    for j in range(len(a)):
        if a[j] < j:
            pik = j - 1
            break
    ans = True
    for j in range(pik, len(a)):
        if a[j] < len(a) - 1 - j:
            ans = False
            break
    if ans:
        print('Yes')
    else:
        print('No')

def ceil(x):
    if int(x) != x:
        return int(x+1)
    else:
        return int(x)


def mafia():
    n = int(input())
    rounds = list(map(int, str(input()).split()))
    count = 0
    rounds.sort(reverse=True)
    for i in range(n-1, 0, -1):
        if rounds[i-1] == rounds[i]:
            continue
        else:
            steps = n - i
            count += steps*(rounds[i-1] - rounds[i])
    rounds[0] -= count
    if rounds[0] > 0:
        k = ceil(rounds[0] / (n - 1))
        count += n * k
        rounds[0] += k * (1 - n)
    if rounds[0] <= 0:
        count += rounds[0]
    print(count)


if __name__ == '__main__':
    mafia()

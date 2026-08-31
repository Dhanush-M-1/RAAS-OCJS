def f():
    n = int(input())
    p = [int(s) for s in input().split()]
    memo = [[p[0], 1, 1]]  # score, seq, people >= me
    for i in range(1,n):
        if p[i] == memo[-1][0]:
            memo[-1][1] += 1
            memo[-1][2] += 1
        else:
            newSum = memo[-1][2] + 1
            memo.append([p[i], 1, newSum])

    half = n//2
    end = 0
    while memo[end][2] <= half:
        end += 1
    end -= 1

    if end < 2:
        print('0 0 0')
        return

    gold = 0
    if memo[gold][2] > memo[end][2]//3:
        print('0 0 0')
        return
    silv = gold + 1
    while memo[gold][2] >= memo[silv][2] - memo[gold][2]:
        silv += 1
        if silv == end:
            print('0 0 0')
            return
    bron = silv + 1
    while memo[gold][2] >= memo[bron][2]-memo[silv][2]:
        bron += 1
        if bron > end:
            print('0 0 0')
            return
    golden = memo[gold][2]
    silver = memo[silv][2]-memo[gold][2]
    bronze = memo[end][2]-memo[silv][2]
    print('{} {} {}'.format(golden,silver,bronze))


t = int(input())
for i in range(t):
    f()
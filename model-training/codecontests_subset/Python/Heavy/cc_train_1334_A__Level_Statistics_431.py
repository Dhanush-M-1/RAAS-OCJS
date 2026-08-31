T = int(input())

def is_ok(stats):
    for i in range(len(stats)-1):
        if stats[i][0]>stats[i+1][0] or stats[i][1]>stats[i+1][1]:
            return 'NO'
        if stats[i+1][0]-stats[i][0] < stats[i+1][1]-stats[i][1]:
            return 'NO'
        if stats[i][1] > stats[i][0]:
            return 'NO'
    if stats[len(stats)-1][1] > stats[len(stats)-1][0]:
        return 'NO'
    else:
        return 'YES'

def solve():
    n = int(input())
    stats = [tuple(map(int, input().split())) for _ in range(n)]
    print(is_ok(stats))


for i in range(T):
    solve()
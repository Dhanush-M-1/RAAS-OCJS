def solve(peeks):
    max_plays = 0
    max_clears = 0
    for play, clear in peeks:
        play_change = play - max_plays
        clear_change = clear - max_clears
        if play_change < 0 or clear_change < 0:
            return 'NO'
        if clear_change > play_change:
            return 'NO'
        
        max_plays = play
        max_clears = clear
    return 'YES'

t = int(input())

for i in range(t):
    n = int(input())
    peeks = []
    for i in range(n):
        plays, clears = map(int, input().split(' '))
        peeks.append([plays, clears])
    print(solve(peeks))
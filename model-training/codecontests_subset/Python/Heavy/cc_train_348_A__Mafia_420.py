import sys

n = int(sys.stdin.readline())
fs = sys.stdin.readline().split()
fs = [int(i) for i in fs]

m = max(fs)
l = min(fs)
s = 0
for f in fs:
    s += m-f

#this means we can play s games until we run out of volunteer supervisors
#at this point everyone has m - s games remaining
#if m - s <= 0, return m
#else, keep playing in section 2...

if m - s <= 0:
    print(m)
else:
    games = 0
    rem = m - s
    #for every n games played, each player plays n-1 games
    mod = rem % ( n - 1 )
    mult = ( rem - mod ) / ( n - 1 )
    games = n * mult
    if mod != 0:
        games += mod + 1
    print(int(games) + s)
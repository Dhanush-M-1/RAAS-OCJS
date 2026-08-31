#!/usr/bin/env python3
from itertools import combinations

n = int(input())
l = [tuple(map(int, input().split(' '))) for _ in range(n)]

matches = combinations(range(n), 2)

c = 0
for x in matches:
    team1 = x[0]
    team2 = x[1]
    hostcolor = lambda team_colors: team_colors[0]
    awaycolor = lambda team_colors: team_colors[1]

    #print('comparing colors %d and %d for match %s' % (hostcolor(l[team1]), awaycolor(l[team2]), x))
    #print('comparing colors %d and %d for match %s' % (hostcolor(l[team2]), awaycolor(l[team1]), x))
    if hostcolor(l[team1]) == awaycolor(l[team2]): 
        c += 1
    if hostcolor(l[team2]) == awaycolor(l[team1]):
        c += 1

print(c)

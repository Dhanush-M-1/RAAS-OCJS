import sys
import itertools

n = int(sys.stdin.readline().split()[0])

colours = [[0 for x in range(2)] for y in range(n)]

row = 0

for line in sys.stdin:
    column = 0
    for word in line.split():
        colours[row][column] = int(word)
        column += 1
    row += 1

matches = list(itertools.combinations(range(n), 2))

guest_uniform = 0

for match in matches:
    host_team = match[0]
    guest_team = match[1]

    if colours[host_team][0] == colours[guest_team][1]:
        guest_uniform += 1

    host_team = match[1]
    guest_team = match[0]

    if colours[host_team][0] == colours[guest_team][1]:
        guest_uniform += 1

print(guest_uniform)

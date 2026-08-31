# https://codeforces.com/problemset/problem/268/A

amountOfTeams = int(input())

teams = []

requiredOutfitChanges = 0

while amountOfTeams > 0:
    teams.append(input().split(" "))

    amountOfTeams = amountOfTeams - 1

for i, firstTeam in enumerate(teams, start=1):
    for secondTeam in teams[i:]:
        if firstTeam[0] == secondTeam[1]:
            requiredOutfitChanges = requiredOutfitChanges + 1
        if firstTeam[1] == secondTeam[0]:
            requiredOutfitChanges = requiredOutfitChanges + 1

print(requiredOutfitChanges)

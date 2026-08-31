Teams = list()

number = input()

team_A = " "
team_B = " "
A, B, X, Y = " ", " ", " ", " "
counter = 0

for x in range(1, int(number)+1):
    team_A, team_B = input().split(" ")
    Teams.append(team_A)
    Teams.append(team_B)

for i in range(0, len(Teams), 2):
    j = i + 2
    A = Teams[i]
    B = Teams[i+1]
    if j < len(Teams):
        for b in range(j, len(Teams), 2):
            X = Teams[b]
            Y = Teams[b+1]
            if A == Y:
                counter += 1
            if X == B:
                counter += 1

print(counter)

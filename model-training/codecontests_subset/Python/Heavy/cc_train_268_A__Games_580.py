number_of_teams = int(input())
teams_with_color = []
count_matches = 0
for n in range(number_of_teams):
    read_line = str(input())
    home_and_guest_color = [int(s) for s in read_line.split(" ")]
    teams_with_color.append(home_and_guest_color)
for n in range(number_of_teams):
    team = teams_with_color[n]
    for t in range(number_of_teams):
        team_to_compare = teams_with_color[t]
        if team != team_to_compare:
            if team[0] == team_to_compare[1]:
                count_matches += 1
print(count_matches)
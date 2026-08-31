all_team_uniform_color = []
individual_team_uniform_color_input = []
total_team = int(input())
result = 0

for i in range(0, total_team):
    individual_team_uniform_color_input = list(map(int, input().split()))
    all_team_uniform_color.append(individual_team_uniform_color_input)

for i in range(0, total_team):
    for j in range(i + 1, total_team):
        if all_team_uniform_color[i][0] == all_team_uniform_color[j][1]:
            result = result + 1
        if all_team_uniform_color[i][1] == all_team_uniform_color[j][0]:
            result = result + 1
        else:
            continue
print(result)

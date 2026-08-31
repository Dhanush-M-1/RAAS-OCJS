teams = int(input())
home, away = {}, {}
result = 0
clash = 0
for team in range(teams):
    colors = input().split()
    home_color, away_color = colors[0], colors[1]
    if home_color == away_color:
        clash += 1
    if home_color in home.keys():
        home[home_color] += 1
    else:
        home[home_color] = 1
    if away_color in away.keys():
        away[away_color] += 1
    else:
        away[away_color] = 1
for item in away.keys():
    if item in home.keys():
        result += away[item] * home[item] - clash * (teams - 1)
print(result)

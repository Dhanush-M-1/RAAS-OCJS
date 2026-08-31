teams = int(input())
games = teams * (teams - 1)
colors = []
for i in range(teams):
    temp = input().split(' ')
    colors.append([int(temp[0]), int(temp[1])])
# print(colors)
different_color = 0;
for j in range(teams):  # host team
    # games:
    # j -> j + 1, j + 2...
    # j + 1 -> j, j + 2...
    # j + 2 -> j, j + 1...
    for k in range(teams): # away team
        if k != j: # team not playing itself
            # colors[team number][home, away]
            if colors[j][0] == colors[k][1]:
                different_color += 1
print(different_color)

import collections
teams = input()

teams_uni = []
for i in range(0,int(teams)):
    teams_uni.append(list(map(int, input().rstrip().split())))


host_team_guest_uniform_matches = 0
for i in range(0,len(teams_uni)):
    for j in range(0,len(teams_uni)):
        if i == j:continue
        # print('['+str(i+1)+'] VS ['+str(j+1)+']')
        if teams_uni[i][0]==teams_uni[j][1]:
            host_team_guest_uniform_matches+=1
            # print('Team [+'+str(i+1)+'] must play with guest uniform ');

print(host_team_guest_uniform_matches)
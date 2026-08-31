n=int(input())

games=[]

for i in range(n):
    games.append(input().split())

new_games=[]
for i in range(len(games)):
    new_games.append(int(games[i][0]))
    new_games.append(int(games[i][1]))

home=[]
away=[]

for j in range(len(new_games)):
    if (j%2==0):
        home.append(new_games[j])
    else:
        away.append(new_games[j])

count=0
for k in range(len(home)):
    for j in range(len(away)):
        if home[k]==away[j]:
            count+=1
        else:
            continue

print(count)
num_teams = int(input())
list = []
count = 0
for x in range(num_teams):
    home, away = map(int, input().split())
    list.append(home)
    list.append(away)
    
for i in range(0, len(list), 2): #checks every even position
    j = list[i] # saves the value in the position i
    for a in range(1, len(list), 2): #checks every odd position
        b = list[a] #saves the value in the position a
        if j == b: #checks if any even position equals any odd position
            count += 1
#print(list)
print(count)
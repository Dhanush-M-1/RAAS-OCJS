n = int(input())
team_colors = []
for i in range (0,n):
    a,b = input().split()
    a = int(a)
    b = int(b)
    c = [a,b]
    team_colors.extend(c)
#now team_colors consists of 2n numbers that represent the home uniform, guest uniform colors of the given n teams
#let 'i' be the home team and 'j' be the guest team
counter = 0
for i in range (0,n):
    for j in range(0,n):
        if(i != j):
            #if ith team home uniform == jth team guest uniform, then counter++
            if(team_colors[2*i] == team_colors[2*j + 1]):
                counter+=1
print(counter)
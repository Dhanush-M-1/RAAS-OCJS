no_of_times = int(input())
list = []
guests = []
homes = []
x= 0
y = 1
answer = 0
games_h = -1
games_g = 0
for n in range(no_of_times):
    z = input()
    h,g = z.split(" ")
    list.append(h)
    list.append(g)
while y<len(list):
    homes.append(list[x])
    guests.append(list[y])
    x+=2
    y+=2
for n in range(no_of_times):
    games_g = 0
    games_h+=1
    for n in range(no_of_times):
        if games_h<len(guests):
            if homes[games_h] == guests[games_g]:
                answer+=1
            games_g+=1
print(answer)

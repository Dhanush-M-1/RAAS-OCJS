def string_victims(list_victims):
    return list_victims[0]+' '+list_victims[1]

def get_next_victims(current_victims):
    murdered,victim=input().strip().split(' ')
    if (murdered == current_victims[0]):
        return [victim,current_victims[1]]
    elif (murdered == current_victims[1]):
        return [current_victims[0],victim]

victims = list(map(str,input().strip().split(' ')))
list_victims = [victims]
day = input().strip()
day = int(day)

for idx in range(0,day):
    x = get_next_victims(list_victims[len(list_victims)-1])
    list_victims=list_victims+[x]

for x in list_victims:
    print (string_victims(x))

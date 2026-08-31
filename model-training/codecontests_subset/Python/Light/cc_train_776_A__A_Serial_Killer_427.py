v1,v2 = map(str, input().split())
days = int(input())
victims = [[v1,v2]]

while days>0:
    killed, new = map(str, input().split())
    if killed == v1:
        v1 = new
    else:
        v2 = new
    victims.append([v1,v2])

    days-=1


for i in victims:
    print(' '.join(i))
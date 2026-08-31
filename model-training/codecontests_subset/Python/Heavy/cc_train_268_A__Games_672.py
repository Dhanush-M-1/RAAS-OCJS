class Team: #-Создаем класс Team

    def __init__(self,h,g): # создаем домашнюю и гостевую форму h и g чтоб избавится от двойных индексов [][]
        self.home=h
        self.guest=g

n=int(input())
team=[]
count=0
for i in range(n):
    home,guest=map(int,input().split())
    team.append(Team(home,guest)) #-создаем список объектов в классе Team, а не вложенные списки
#print(team)
for i in range(n-1):
    for j in range(i+1,n):
        if team[i].home==team[j].guest:
            count+=1
        if team[i].guest==team[j].home:
            count+=1
print(count)
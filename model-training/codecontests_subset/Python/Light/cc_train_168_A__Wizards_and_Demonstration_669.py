from math import ceil
n,x,y = map(int,input().split())
total_people_need = ceil((float(n)/100) * float(y))
puppet_need = max(int(total_people_need) - x, 0)
print(puppet_need)

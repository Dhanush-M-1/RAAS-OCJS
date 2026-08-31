a,b = map(int,input().split())
mas = []
for i in range(a):
    mas.append(1)
    if len(mas)%b==0:
        mas.append(1)
print(len(mas))
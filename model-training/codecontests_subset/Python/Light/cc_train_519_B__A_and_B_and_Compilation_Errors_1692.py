x=input()
emon=input().split()
emon.sort()
emon1=input().split()
emon1.sort()
emon1.append(' ')
emon2=input().split()
emon2.sort()
emon2.append(' ')
emon2.append(' ')

for i in range(len(emon)):
    if (emon[i]!=emon1[i]):
        print(emon[i])
        break
for i in range(len(emon1)):
    if (emon1[i]!=emon2[i]):
        print(emon1[i])
        break
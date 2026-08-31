
sir = input()
vector=[]
index = 0
firstG = []
secondG = []
thirdG = []
final = []


vectorsplit=(sir.split("+"))
vector = sir.split("+")


for valoare in vectorsplit:

    if valoare == '1':
        firstG.append(1)
    elif valoare == '2':
        secondG.append(2)
    else:
        thirdG.append(3)


final=firstG+secondG+thirdG
rez=[]
while index<len(final):
    rez.append(final[index])
    rez.append('+')
    index+=1
rez = rez[:-1]
index = 0
while index<len(rez):
    print(rez[index],sep='',end='')
    index+=1

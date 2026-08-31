s=input()
l=s.split(' ')
a=int(l[0])
b=int(l[1])

toBurn=0
burnt=a
total=a
i=0
while int(burnt/b)>0:
    toBurn=int(burnt/b)
    burnt=burnt%b
    total+=toBurn
    burnt+=toBurn
    toBurnt=0
print(total)

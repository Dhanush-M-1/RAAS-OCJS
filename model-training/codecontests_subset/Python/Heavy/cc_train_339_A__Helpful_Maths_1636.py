mat=input()

uno=int(0)
dos=int(0)
tres=int(0)
p1=str("")

for x in mat:
    if x=="1":
        uno=int(uno+1)
    if x=="2":
        dos=int(dos+1)
    if x=="3":
        tres=int(tres+1)

while uno>0:
    p1=str(p1+"1")
    uno=int(uno-1)
    if ((uno!=int(0)) or (dos!=int(0)) or (tres!=int(0))):
        p1=str(p1+"+")

while dos>0:
    p1=str(p1+"2")
    dos=int(dos-1)
    if ((dos!=int(0)) or (tres!=int(0))):
        p1=str(p1+"+")
    

while tres>0:
    p1=str(p1+"3")
    tres=int(tres-1)
    if (tres!=int(0)):
        p1=str(p1+"+")
    

print(p1)

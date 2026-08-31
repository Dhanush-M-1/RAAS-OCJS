lch = input()
ch=""
while len(ch)!=int(lch):
  ch=input()
z=0
a=""
liste = []
for i in range(len(ch)):
  if(i!=len(ch)):
    a=ch[z:i+1]
    liste.append(a)
    z=i
#print(liste)
del liste[0]
#print(liste)
listeocc=[]
for i in range(len(liste)):
  val=liste[i]
  occ=0
  for j in range(len(liste)): 
    if(val==liste[j]):
      occ=occ+1
  listeocc.append(occ)
#print(listeocc)
maxocc=int(listeocc[0])
savepos=0
for i in range(len(listeocc)): 
  if(int(listeocc[i])>int(maxocc)):
    maxocc=listeocc[i]
    savepos=i
print(liste[savepos])
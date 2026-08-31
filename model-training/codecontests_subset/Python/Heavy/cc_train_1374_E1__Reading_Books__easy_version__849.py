l=input().split()
n=int(l[0])
k=int(l[1])
l=[]
arrboth=[]
arralice=[]
arrbob=[]
for i in range(n):
    lo=input().split()
    x=int(lo[0])
    u=int(lo[1])
    v=int(lo[2])
    if(u==1 and v==1):
        arrboth.append(x)
    elif(u==1):
        arralice.append(x)
    elif(v==1):
        arrbob.append(x)
arrbob.sort()
arralice.sort()
arrboth.sort()
pref1=[0 for i in range(len(arrboth)+1)]
pref2=[0 for i in range(len(arralice)+1)]
pref3=[0 for i in range(len(arrbob)+1)]
sumi=0
for i in range(1,len(arrboth)+1):
    sumi+=arrboth[i-1]
    pref1[i]=sumi
sumi=0
for i in range(1,len(arrbob)+1):
    sumi+=arrbob[i-1]
    pref3[i]=sumi
sumi=0
for i in range(1,len(arralice)+1):
    sumi+=arralice[i-1]
    pref2[i]=sumi
z=[]
for i in range(min(len(arrboth),k)+1):
    if(k-i>len(arrbob) or k-i>len(arralice)):
        continue
    z.append(pref1[i]+pref2[k-i]+pref3[k-i])
if(z==[]):
    print(-1)
else:
    print(min(z))

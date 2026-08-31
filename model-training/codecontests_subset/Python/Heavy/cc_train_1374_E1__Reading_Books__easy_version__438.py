def reading(numb,mass,c1,c2):
    if c1<numb or c2<numb :
        return -1
    true_mass1=[]
    true_mass2=[]
    true_mass3=[]
    for i in mass:
        if i[1]!=0 or i[2]!=0:
            if i[1]==0:
                true_mass1.append(i)
            elif i[2]==0:
                true_mass2.append(i)
            else:
                true_mass3.append(i)
    true_mass1.sort(key = lambda p:p[0])
    true_mass2.sort(key=lambda p: p[0])
    true_mass3.sort(key=lambda p: p[0])
    #print(true_mass3)
    i=0
    j=0
    k=0
    deltai=len(true_mass3)
    deltaj=len(true_mass2)
    deltak=len(true_mass1)
    result=0
    for d in range(numb):
        if deltai!=i and deltaj!=j and deltak!=k:
            if true_mass3[i][0]<=true_mass2[j][0]+true_mass1[k][0]:
                result+=true_mass3[i][0]
                i+=1
            else:
                result += true_mass2[j][0] + true_mass1[k][0]
                k += 1
                j += 1
        elif deltai==i:
            result += true_mass2[j][0] + true_mass1[k][0]
            k+=1
            j+=1
        elif deltaj==j or deltak==k:
            result += true_mass3[i][0]
            i += 1
    return result

t=[int(i) for i in input().strip().split()]
n=t[1]
count1=0
count2=0
mass=[]
for i in range(t[0]):
    string=[int(j) for j in input().strip().split()]
    mass.append(string)
    if string[1]==1:
        count1+=1
    if string[2]==1:
        count2+=1
print(reading(n,mass,count1,count2))
S=input()
I=input()
S=S.split(" ")
I=I.split(" ")
Tama=int(S[0])
TamaG=int(S[1]) #es para dividir
L=[]
for i in range(0,Tama):
    L.append(int(I[i]))
L1=[]
for i in L:
    if(TamaG%i==0):
        L1.append(TamaG/i)
L1.sort()
print(int(L1[0]))

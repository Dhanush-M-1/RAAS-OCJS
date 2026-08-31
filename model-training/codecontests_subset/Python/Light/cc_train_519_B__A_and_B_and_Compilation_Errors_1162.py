n=int(input())
ch=input()
ch1=input()
ch2=input()
L=ch.split(' ')
L1=ch1.split(' ')
L2=ch2.split(' ')
L.sort()
L1.sort()
L2.sort()
for i in range (len(L2)):
    L.remove(L2[i])
    L1.remove(L2[i])

if L1[0]==L[0]:
    print(L[1])
else :
    print(L[0])
print(L1[0])
A = int(input())
V = input()
F=0
A=0
I=0

for i in range(len(V)):
    if V[i]=='F':
        F+=1
    elif V[i]=='A':
        A+=1
    else:
        I+=1

if I>=2:
    print(0)
else:
    if I:
        print(1)
    else:
        if A:
            print(A)
        else:
            print(0)
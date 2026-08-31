n = int(input())
a = input()
b = input()
c = input()
A,B,C = 0,0,0
for i in a.split():
    A = A+int(i)
for j in b.split():
    B = B+int(j)
for k in c.split():
    C =C + int(k)
print(A-B)
print(B-C)

    
    


    
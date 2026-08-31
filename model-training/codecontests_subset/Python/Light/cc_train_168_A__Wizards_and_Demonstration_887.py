l=input()
l=l.split()
n=int(l[0])
x=int(l[1])
y=int(l[2])
#print((y*n)//100)
#print(-(y*n))
#print(-(y*n)//100) divisao inteira em python arredonda pra baixo
k=(-(-(y*n)//100))
#print(k)
k=k-x
if k>=0:
    print(k)
else:
    print('0')

nu=int(input())
number=int(input())
cont=0
for i in (str(number)):
    if(i=="8"):
        cont+=1
nu=nu/11
if(cont>nu):
    print(int(nu))
else:
    print(int(cont))
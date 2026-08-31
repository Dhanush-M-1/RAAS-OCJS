def correct(lista,n):
    for j in range(n-1):
        d1=lista[j+1][0]-lista[j][0]
        d2=lista[j+1][1]-lista[j][1]
        if lista[j][0]<lista[j][1]:
            return False
        if d1<0 or d2<0:
            return False
        elif d1<d2:
            return False
    if lista[0][0]<lista[0][1]:
        return False
    return True
t=int(input())
for i in range(t):
    n=int(input())
    lista=[]
    for j in range(n):
        x,y=input().split()
        x=int(x)
        y=int(y)
        lista+=[[x,y]]
    if correct(lista,n):
        print("YES")
    else:
        print("NO")

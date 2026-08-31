a=input()
b=input()
cont=0
i=0
while(i<int(a) and cont<=int(a)//11-1):
    if b[i]=="8":
        cont=cont+1
    i=i+1
print(cont)
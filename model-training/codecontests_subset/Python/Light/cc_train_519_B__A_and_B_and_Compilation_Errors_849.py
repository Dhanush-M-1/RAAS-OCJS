def prin(l,l1):
    cambia=0
    k=0
    while(k<len(l1)):
        if(l[k]!=l1[k]):
            print(l[k])
            cambia=1
            break
        k+=1
    if(cambia==0):
        print(l[len(l)-1])
n=input("")
l=list(map(int,input().split(" ")))
l1=list(map(int,input().split(" ")))
l2=list(map(int,input().split(" ")))
l=sorted(l)
l1=sorted(l1)
l2=sorted(l2)
prin(l,l1)
prin(l1,l2)
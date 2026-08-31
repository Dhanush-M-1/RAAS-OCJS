name1,name2=input().split()
n=int(input())
print(name1,name2)
while(n>0):
    p,q=input().split()
    if(p==name1):
        name1=q
        print(name1,name2)
        n=n-1
        continue
    if(p==name2):
        name2=q
        print(name1,name2)
        n=n-1
        continue
    if(q==name1):
        name1=p
        print(name1,name2)
        n=n-1
        continue
    if(q==name2):
        name2=p
        print(name1,name2)
        n=n-1
        continue
    

    
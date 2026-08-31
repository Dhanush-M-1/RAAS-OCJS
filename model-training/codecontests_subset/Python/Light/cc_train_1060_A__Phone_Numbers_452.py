a=int(input())
b=input()
d=[]
if b.count('8')>1:
    k=1
else:
    k=0
if a>=11 and b.count('8')>0:
    for i in range(a):
        if b[i]!='8' and b[i] not in d:
            d.append(b[i])
            k+=1
    print(min((a//11),(a//k),b.count('8')))        
else:
    print(0)
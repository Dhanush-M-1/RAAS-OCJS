ch=input("")
n,k=int(ch.split(" ")[0]),int(ch.split(" ")[1])
ch=input("")
l=[]
for i in range(n):
    l.append(int(ch.split(" ")[i]))
lv=[]
for i in l :
    if k%i==0 :
        lv.append(i)
        

lv.sort()
h=k//lv[-1]
print(h)


        
a=int(input())
st=input()
eight=0
for i in range(0,len(st)):
    if st[i]=='8':
        eight+=1
banyak=len(st)//11
if banyak==0:
    c=0
elif banyak<eight:
    c=banyak
else :
    c=eight
print(c)
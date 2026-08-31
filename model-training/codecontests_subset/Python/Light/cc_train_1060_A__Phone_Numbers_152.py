a=int(input(""))
digs=[int(i) for i in input("")]
e=0
res=0
for dig in digs:
   if dig==8:
      e+=1
while e>0 and a>0:
   e-=1
   if a>10:
      a-=11
   else : break
   res+=1
print(res)

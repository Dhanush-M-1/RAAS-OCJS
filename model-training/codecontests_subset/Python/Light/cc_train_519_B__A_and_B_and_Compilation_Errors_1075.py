n=int(input())
a=input()
a=a.split()
b=input()
b=b.split()
c=input()
c=c.split()
suma=0
sumb=0
sumc=0
for i in a:
    suma=suma+int(i)
for i in b:
    sumb=sumb+int(i)
for i in c:
    sumc=sumc+int(i)
ab= suma-sumb
bc=sumb-sumc
print(ab)
print(bc)
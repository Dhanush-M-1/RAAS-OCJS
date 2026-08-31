n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]
suma=sum(a)
sumb=sum(b)
sumc=sum(c)
print(str(suma-sumb)+"\n"+str(sumb-sumc))
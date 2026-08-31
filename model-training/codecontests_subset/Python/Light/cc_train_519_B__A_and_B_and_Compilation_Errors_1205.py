n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
suma=0
for i in a:
	suma+=i

sumb=0
for i in b:
	sumb+=i

sumc=0
for i in c:
	sumc+=i	

print(suma-sumb)
print(sumb-sumc)

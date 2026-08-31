a,b=input().split()
a=int(a)
b=int(b)
can=a
hrs=a
while 1==1:
  ar=[]
  while can>=b:
	  r=can%b
	  can=can//b
	  ar.append(r)
	  hrs=hrs+can
  s=sum(ar)+can
  can=s
  if s<b:
    break
#print(sum(ar)+s)
print(hrs)
line=input()
A,B=line.split()
a,b=int(A),int(B)
m=0
c=0
while a!=0:
   m=m+a
   c=c+a%b
   a=a//b
   if c>=b:
       c=c-b
       a=a+1
print(m)
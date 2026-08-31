a,b = input().split()
a=int(a)
b=int(b)
r=a
j=a
while(j>=b):
   p=j//b
   r+=p
   q=j%b
   j=p+q

print(r)

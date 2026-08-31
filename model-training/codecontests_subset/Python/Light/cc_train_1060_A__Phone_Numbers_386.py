n=int(input())
while (n< 1) or (n>100):
    n=int(input())
ch=input()
while not ch.isdigit() or len(ch)>n:
    ch=input()
    
s=0
for i in ch:
    if i=='8':
        s+=1
if s==0:
    print(0)
elif (s> n//11):
    print(n//11)
else:
    print(s)

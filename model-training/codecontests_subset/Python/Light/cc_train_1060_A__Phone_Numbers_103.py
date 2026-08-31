n=int(input())
s=input()
x=int(n/11)
y=0
for i in range (0, n):
    if s[i]=='8':
        y=y+1
if x>y:
    pn=y
else:
    pn=x
print(pn)
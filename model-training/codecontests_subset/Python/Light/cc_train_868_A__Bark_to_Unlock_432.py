w=input()
n=int(input())
b=0
d=0
f=0
for i in range(n):
    s=input()
    if (s==w):
        b=1
    if (s[0]==w[1]):
        d=1
    if (s[1]==w[0]):
        f=1

if (b==1 or (d==1 and f==1)):
    print("YES")
else:
    print("NO")

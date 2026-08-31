s=input()
n=int(input())
x=""
for i in range(n):
    x+=input()
a,b=x[::2],x[1::2]
if s in x:print("YES")
elif s[0] in b and s[1] in a:print("YES")
else:print("NO")
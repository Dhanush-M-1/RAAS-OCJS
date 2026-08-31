n=int(input())
s=input()
x=n//11
y=0
for i in range (0, n):
    if s[i]=='8':
        y+=1
print(min(x, y))
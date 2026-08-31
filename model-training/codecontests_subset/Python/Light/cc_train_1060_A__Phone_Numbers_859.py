n=int(input())
ch=input()
x=n//11
y=ch.count('8')
if y>=x:
    print(x)
else:
    print(y)
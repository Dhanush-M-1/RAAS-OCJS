n=int(input())
s=input()
c=s.count('8')
x=n//11
if c>=x:
    print(n//11)
elif c < x:
    print(c)
else:
    print(0)
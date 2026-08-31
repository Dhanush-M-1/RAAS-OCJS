n=int(input())
s=input()
x=s.count('8')
if x==0:
    print("0")
else:
    c=n//11
    if c<x:
        print(c)
    else:
        print(x)

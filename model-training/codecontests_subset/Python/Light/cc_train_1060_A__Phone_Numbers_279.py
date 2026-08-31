n = int(input())
s=input()
l = [int(x) for x in str(s)]
nc = l.count(8)
c=n//11
if c<=nc:
    print(c)
else:
    print(nc)
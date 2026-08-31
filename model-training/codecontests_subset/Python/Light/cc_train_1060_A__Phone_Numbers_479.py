n=int(input())
s=input()
s=list(s)
c=s.count("8")
if n//11<=c:
    print(n//11)
elif c==0:
    print(c)
elif n//11>c:
    print(c)
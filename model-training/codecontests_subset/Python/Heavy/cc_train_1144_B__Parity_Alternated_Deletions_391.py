n=int(input())
s=input()
a=[int(x) for x in s.split() if int(x)%2==0]
b=[int(x) for x in s.split() if int(x)%2!=0]
if abs(len(a)-len(b))<2:
    print(0)
elif len(b)==0:
    a.sort()
    print(sum(a[:len(a)-1]))
elif len(a)==0:
    b.sort()
    print(sum(b[:len(b)-1]))
elif len(a)>len(b):
    x=len(b)+1
    a.sort()
    for i in range(x):
        m=a[-1]
        a.remove(m)
    print(sum(a))
else:
    x=len(a)+1
    b.sort()
    for i in range(x):
        m=b[-1]
        b.remove(m)
    print(sum(b))

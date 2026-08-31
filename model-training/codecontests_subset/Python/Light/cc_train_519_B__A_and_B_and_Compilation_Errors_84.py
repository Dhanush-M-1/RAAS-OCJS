a=int(input())
b=input().split()
c=input().split()
d=input().split()
b=[int(i) for i in b]
c=[int(i) for i in c]
d=[int(i) for i in d]
b=sum(b)
c=sum(c)
d=sum(d)
print(b-c)
print(c-d)

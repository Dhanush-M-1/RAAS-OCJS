n=int(input())
a=input().split()
b=input().split()
c=input().split()
a=[int(i) for i in a]
a=sum(a)
b=[int(i) for i in b]
b=sum(b)
c=[int(i) for i in c]
c=sum(c)
print(a-b)
print(b-c)
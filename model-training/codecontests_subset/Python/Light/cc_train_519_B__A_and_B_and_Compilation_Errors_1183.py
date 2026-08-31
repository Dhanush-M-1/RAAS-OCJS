n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))

c=list(map(int,input().split()))

a=sum(a)
b=sum(b)
c=sum(c)
print(a-b)
print(b-c)
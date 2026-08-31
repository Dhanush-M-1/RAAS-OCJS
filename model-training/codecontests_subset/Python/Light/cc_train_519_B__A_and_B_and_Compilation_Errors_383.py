n=int(input())
x=0
a1=list(map(int,input().split()))
a2=list(map(int,input().split()))
a3=list(map(int,input().split()))
for i in a1:
    x^=i
x1=x
for i in a2:
    x^=i
print(x)
x1^=x
for i in a3:
    x1^=i
print(x1)
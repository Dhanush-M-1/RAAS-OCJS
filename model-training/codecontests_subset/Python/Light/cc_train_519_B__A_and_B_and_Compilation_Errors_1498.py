n=int(input())
l=list(map(int,input().split()))
x=list(map(int,input().split()))
y=list(map(int,input().split()))
a,b,c=0,0,0
for i in l:
    a=a+i
for j in x:
    b=b+j
for i in y:
    c=c+i
print(a-b)
print(b-c)
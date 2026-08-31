a1,b1=input().split()
a=int(a1)
b=int(b1)
count=0
c=0
while c<a:
    count=count+1
    if count==b:
        a=a+1
        count=0
    c=c+1
print(a)

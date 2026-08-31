a,b=map(int,input().split())
i=0
t=a
while a>=b:
    a-=b
    a+=1
    i+=1
print(i+t)

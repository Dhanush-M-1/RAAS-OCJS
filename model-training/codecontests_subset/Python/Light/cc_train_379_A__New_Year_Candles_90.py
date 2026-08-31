a,b=map(int, input().split())
c=0
count=0
while a>0:
    count+=1
    c+=1
    a-=1
    if(c==b):
        a=a+1
        c=c-b
print(count)
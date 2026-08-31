a,b = map(int,input().split())
count=0
i = 1
while a != 0:
    count+=1
    if count == i*b:
        a+=1
        i+=1
    a-=1
print(count)
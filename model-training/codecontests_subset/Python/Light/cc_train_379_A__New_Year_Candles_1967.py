a,b = map(int,input().split())
hours = a
d = a
while True:
    if d >= b:
        hours+= 1
        d-=b
        d+=1
    else:
        break
print(hours)

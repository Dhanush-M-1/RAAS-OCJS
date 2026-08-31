a,b = map(int,input().split())
hour,c = 0,0
while a:
    hour += 1
    a -= 1
    c +=1
    if c == b:
        c = 0
        a += 1
print(hour)
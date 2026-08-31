x,y = map(int,input().split())
total = 0
while x != 0:
    total += ((x//y)*y)
    x = ((x//y)+(x%y))
    if x < y:
        total += x
        break
print(total)
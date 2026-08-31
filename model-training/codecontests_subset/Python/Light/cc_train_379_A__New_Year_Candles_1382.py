container,b = map(int,input().split())
day = 0
burnt = 0
while container != 0:
    container -= 1
    day += 1
    burnt += 1
    if burnt==b:
        container += 1
        burnt = 0
print(day)
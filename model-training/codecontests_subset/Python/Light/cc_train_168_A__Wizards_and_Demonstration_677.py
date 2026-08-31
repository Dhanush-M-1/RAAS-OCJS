[n,x,y] = map(int, input().split())
percent = y/100
minimum = n * percent
if minimum != minimum//1:
    minimum = minimum//1 + 1
if x >= minimum:
    print(int(0))
else: 
    print(int(minimum - x))
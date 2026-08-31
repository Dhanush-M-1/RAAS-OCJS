n = int(input())
y = 0

for i in range(3):
    a = [int(i) for i in input().split()]
    x = sum(a)
    if i == 0:
        y = x
    else:
        print(y - x)
        y = x
    

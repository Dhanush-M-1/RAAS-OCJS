
a, b = map(int, input().split())
stack = 0
hours = 0
 
while a != 0:
    hours += 1
    stack += 1
    if stack == b:
        a += 1
        stack = 0
    a -= 1
print(hours)
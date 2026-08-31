a,b = map(int,input().split())
hours = a
while a // b >= 1:
    hours += a // b
    a = a // b + a % b
print(hours)
    
    

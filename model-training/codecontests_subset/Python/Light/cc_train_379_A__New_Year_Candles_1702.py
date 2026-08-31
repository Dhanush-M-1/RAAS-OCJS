a, b = map(int, input().split())
num_hours = a
while True:
    if a < b:
        break
    num_hours += a // b
    a = a // b + a % b
    
print(num_hours)
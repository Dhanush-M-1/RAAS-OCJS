a,b = map(int, input().strip().split(" "))
time = a

while True:
    rem = a % b
    a = int(a/b)
    time += a
    a = a + rem
    
    if int(a / b) == 0:
        break
    else:
        continue
    
print(int(time))
#Get input
a, b = input().split()
a = int(a)
b = int(b)
num_hours = a

#make a while loop to see how much time is left
while True:
    if a < b:
        break
    num_hours += a // b
    a =  a % b + a // b
    
print((num_hours))
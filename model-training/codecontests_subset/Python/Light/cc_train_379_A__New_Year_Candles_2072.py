a, b = input().split(" ")
a = int(a)
b = int(b)
time = a


while a > 1:
    a = a / b
    time += a

print(int(time))
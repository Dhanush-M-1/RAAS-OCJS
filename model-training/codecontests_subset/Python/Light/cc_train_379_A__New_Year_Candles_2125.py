line = input()
a, b = line.split(" ")
a = int(a)
b = int(b)
s = a
while (int(s / b)) > 0:
    a += int(s / b)
    y = s % b
    s = int(s / b) + y
print(a)
a, b = input().split()
s = int(a)
while int(a) >= int(b):
    s += int(a) // int(b)
    a = int(a) // int(b) + int(a) % int(b)
print(s)
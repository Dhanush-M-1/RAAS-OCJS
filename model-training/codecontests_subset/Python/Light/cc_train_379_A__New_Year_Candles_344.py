a, b = input().split()
a = int(a)
b = int(b)
khela = a
while a >= b:
    x = a%b
    a = int(a / b)
    khela += a
    a += x
print(khela)
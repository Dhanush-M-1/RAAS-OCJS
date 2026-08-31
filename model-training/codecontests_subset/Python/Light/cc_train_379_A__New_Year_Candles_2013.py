L = input()
L = L.split()
a = int(L[0])
b = int(L[1])
T = a
while a>=b:
    T += a//b
    a = a//b +a%b
print(T)
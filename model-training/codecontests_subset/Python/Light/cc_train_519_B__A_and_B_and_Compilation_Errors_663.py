
a = 0
b = 0 
c = 0
n = int(input())
stringIN = input() 
for el in stringIN.split(): a += int(el)
stringIN = input() 
for el in stringIN.split(): b += int(el)
stringIN = input()
for el in stringIN.split(): c += int(el)
print(a - b)
print(b - c)


# O(n)
# make all comparaisons in one loop, 

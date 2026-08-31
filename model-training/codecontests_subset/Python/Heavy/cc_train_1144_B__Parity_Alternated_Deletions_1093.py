mas_y = [] 
mas_x = [] 
otv = 0 
n = int(input()) 
vvod = input() 
mas_str = vvod.split(' ') 
for i in range(n): 
    chislo = int(mas_str[i]) 
    otv += chislo 
    if chislo%2 == 1: 
        mas_y.append(chislo) 
    else: 
        mas_x.append(chislo) 
minim = min(len(mas_y), len(mas_x)) 
mas_y.sort() 
mas_x.sort() 
for i in range(minim): 
    otv -= mas_y[-i-1] 
    otv -= mas_x[-i-1] 
if otv != 0: 
    if len(mas_y) > len(mas_x): 
        otv -= mas_y[-minim-1] 
    else: 
        otv -= mas_x[-minim-1] 
print(otv) 

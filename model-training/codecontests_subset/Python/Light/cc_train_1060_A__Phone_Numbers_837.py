a =int(input())
b = input()
delapan = b.count('8')
sisa = (len(b)-delapan) 
while delapan*10 > sisa:
    delapan = delapan -1
    sisa = sisa +1
print(delapan)

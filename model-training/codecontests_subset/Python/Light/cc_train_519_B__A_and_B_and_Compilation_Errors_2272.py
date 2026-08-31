n = int (input ()) 
mas = sorted(list (map (int, input ().split ())))
mas1 = sorted(list (map (int, input ().split ())))
mas2 = sorted(list (map (int, input ().split ())))
s1 = 0
s2 = 0
for x in range(len(mas1)):
    if mas[x] != mas1[x]:
        s1 = mas[x]
    if s1 != 0:
        break
if s1 == 0:
    s1 = mas[len(mas) - 1]
for x in range(len(mas2)):
    if mas1[x] != mas2[x]:
        s2 = mas1[x]
    if s2 != 0:
        break
if s2 == 0:
    s2 = mas1[len(mas1) - 1]
print (s1)
print (s2)
n = int(input())
a = input()
a0 = 0
a1 = 0
a2 = 0
a3 = 0
a4 = 0
a5 = 0
a6 = 0
a7 = 0
a8 = 0
a9 = 0
for i in a:
    if i == '0':
        a0 += 1
    if i == '1':
        a1 += 1
    if i == '2':
        a2 += 1
    if i == '3':
        a3 += 1
    if i == '4':
        a4 += 1
    if i == '5':
        a5 += 1
    if i == '6':
        a6 += 1
    if i == '7':
        a7 += 1
    if i == '8':
        a8 += 1
    if i == '9':
        a9 += 1
mm = sum([a8, a1, a2, a3, a4, a5, a6, a7, a9, a0])
kk = a8 
k = 0 
while kk > 0 and mm >= 11:
    k += 1
    mm -= 11
    kk -= 1
print(k)
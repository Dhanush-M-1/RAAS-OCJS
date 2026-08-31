n = int(input())
s = input()
count1 = 0
for i in range(n):
    if s[i] == "8":
        count1 += 1
if count1 == 0:
    print(0)
else:
    tam = n//11
    if tam <= count1:
        print(tam)
    else:
        print(count1)
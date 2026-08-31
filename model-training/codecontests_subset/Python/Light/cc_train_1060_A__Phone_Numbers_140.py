n = int(input())
s = input()
count8 = 0
if '8' in s and n >= 11:
    for i in range(n):
        if '8' == s[i]:
            count8 += 1
    count11 = n//11
    if count8 > count11:
        print(count11)
    else: 
        print(count8)
else:
    print(0)
        
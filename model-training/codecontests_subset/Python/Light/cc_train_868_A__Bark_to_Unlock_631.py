from math import ceil
Input=lambda:map(int,input().split())

Ramz = input()
Flag1 = Flag2 = False
for i in range(int(input())):
    s = input()
    if Ramz == s:
        Flag1 = Flag2 = True
        break
    if Ramz[0] == s[1]:
        Flag1 = True
    if Ramz[1] == s[0]:
        Flag2 = True
    

print("YES" if Flag1 & Flag2 else "NO")




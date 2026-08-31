long = int(input())
ch = input()
nb = 0
for i in range(0, long):
    if ch[i] == '8':
        nb += 1
div=long//11
if long>=11:
    print(min(div,nb))
else:
    print(0)
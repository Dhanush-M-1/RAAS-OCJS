n = int(input())
ent = input()
a = 0
f = 0
i = 0
 
for _ in range (0, len(ent)):
    if ent[_] == "A":
        a+= 1
    elif ent[_] == "F":
        f += 1
    elif ent[_] == "I":
        i += 1
 
if i == 0:
    print(a)
else:
    if i >= 2:
        print("0")
    else:
        print("1")
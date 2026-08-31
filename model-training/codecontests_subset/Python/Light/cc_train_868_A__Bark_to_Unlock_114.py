y = input()
x = int(input())
t = []
ansp = []
u1 = []
u2 = []
for i in range(x):
    s = input()
    t.append(s)
for num in t:
    if num[::-1] == y:
        u1.append(num)
        u2.append(num)
    elif num == y:
        u1.append(num)
        u2.append(num)
    elif (num[1] == y[0]):
        u1.append(num)
    elif (num[0] == y[1]):
        u2.append(num)
if (len(u1)>0 and len(u2) > 0):
    print("YES")
else:
    print("NO")
        
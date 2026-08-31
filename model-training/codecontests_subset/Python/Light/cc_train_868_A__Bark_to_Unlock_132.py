pas=input()
n=int(input())
pl , lp = False , False
for i in range(n):
    a = input()
    if a == pas:
        pl,lp = True, True
        break
    if a[0] == pas[1]:
        lp = True
    if a[1] == pas[0]:
        pl = True
if (pl == True) and (lp==True):
    print("YES")
else:
    print("NO")
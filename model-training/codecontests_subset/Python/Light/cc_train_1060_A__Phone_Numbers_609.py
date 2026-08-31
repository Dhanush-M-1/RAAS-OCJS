n = int(input())
s = list(input())
d = 0
for i in range(n):
    if (int(s[i])==8):
        d = d + 1
if (d==0):
    print (0)
else:
    if (d<=(n//11)):
        print (d)
    else:
        print (n//11)
        

n = int(input())
m = input()
t = 0
for i in range (len(m)):
    if (m[i]=='8'):
        t=t+1

if (n//11<=t):
    print (n//11)
    print ()
else:
    print (t)
    print ()

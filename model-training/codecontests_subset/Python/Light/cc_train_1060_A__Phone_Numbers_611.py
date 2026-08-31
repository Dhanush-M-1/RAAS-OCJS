x=int(input())
s=input()
c=0
for i in s:
    if i=="8":
        c+=1
a=len(s)-c
if x<11 or c==0:
    print(0)
elif c*10<=a:
    print(c)
else:
    print(int(len(s)/11))


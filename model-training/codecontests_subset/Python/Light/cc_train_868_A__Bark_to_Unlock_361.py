s2=[]
fl=0
fl1=0
s=str(input())
a=int(input())
for i in range(1,a+1):
    s1=str(input())
    if (s1 == s):
        fl = 1
        fl1 = 1
        break
    if (s1[1] == s[0]):
        fl = 1
    if(s1[0]==s[1]):
        fl1=1
if(fl==1 and fl1==1) :
    print("YES")
else:
    print("NO")

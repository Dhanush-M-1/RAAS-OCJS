n=input()
k=int(input())
flag1=flag2=flag3=0
for i in range(k):
    s=input()
    if s==n:
        flag1=1
        flag2=1
    elif s[0]==n[1] and s[1]==n[0]:
        flag3=1
    elif s[0]==n[1]:
        flag1=1
    elif s[1]==n[0]:
        flag2=1
if(flag1 ==1 and flag2==1 or flag3==1):
    print("YES")
else:
    print("NO")
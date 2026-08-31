string1 = input()
n = int(input())
flag1,flag2 = False,False
for i in range(n):
    string2 = input()
    if (string2==string1):
        flag1, flag2 = True,True
    if(string2[1] == string1[0]):
        flag1 = True
    if(string2[0]==string1[1]):
        flag2 = True

if(flag1 & flag2):
    print("YES")
else:
    print("NO")

s= input()
s = list(s)
n= int(input())
count1= 0
count2 =0
c1=0
while(n):
    flag = False
    s1 = input()
    s1  = list(s1)
    if(s[0]==s1[0] and s[1]==s1[1]):
        c1 = 1
    if(s[0]==s1[1]):
        count1=1
    if(s[1] == s1[0]):
        count2=1
    n-=1
if(count1+count2==2 or c1==1):
    print("YES")
else:
    print("NO")

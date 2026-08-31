s=input()
t=int(input())
count=0
count1=0
for i in range(t):
    a=input()
    if a[0]==s[1]:
        count1=count1+1
    if a[1]==s[0]:
        count=count+1
    if a == s:
        count=count+1
        count1=count1+1
if count1>0 and count>0:
    print("YES")
else:
    print("NO")


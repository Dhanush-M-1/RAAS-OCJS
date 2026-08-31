inp=input()
n=int(input())
ans=0
flag1=0
flag2=0
while n>0:
    temp=input()
    if temp==inp:
        ans=1
    if inp[1]==temp[0]:
        flag2=1
    if inp[0]==temp[1]:
        flag1=1
    n-=1
if ans or (flag1 and flag2):
    print("YES")
else:
    print("NO")

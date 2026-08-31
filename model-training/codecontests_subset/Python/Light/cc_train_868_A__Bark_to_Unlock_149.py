s=input()
n=int(input())
ans=""
for i in range(n):
    x=input()
    if s==x or s[::-1]==x:
        ans+="0"
    elif s[0]==x[1]:
        ans+="1"
    elif s[1]==x[0]:
        ans+="2"
if ans.count("0")>=1:
    print("YES")
elif ans.count("1")>=1 and ans.count("2")>=1:
    print("YES")
else:
    print("NO")
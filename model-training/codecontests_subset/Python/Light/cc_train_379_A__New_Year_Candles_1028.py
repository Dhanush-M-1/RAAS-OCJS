a,b=map(int,input().split())
c=0
ans=0
burned=0
ans += a
burned += a
while burned//b!=0:
    ans += burned//b
    burned = burned%b+burned//b
print(ans)

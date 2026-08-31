a,b=[int(x) for x in input().split()]
old=ans=0
while a:ans+=a;old+=a%b;a//=b;a+=old//b;old%=b;
print(ans)
# A. Phone Numbers
n=int(input())
s=input()
m=s.count("8")
ans=min(m,n//11)
print(ans)
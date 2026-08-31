n=int(input())
s=input()

m=len(s)
v=s.count('8')
out=min(v,m//11)

print(out)

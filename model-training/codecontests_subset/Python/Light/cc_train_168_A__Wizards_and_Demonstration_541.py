a,b,c=map(int,input().split())
p=-min(0,-a*c/100+b)
print(int(p))if p==int(p) else print(int(p)+1)
r=lambda i:map(int,input().split()[i:])
n,m=r(0)
a=[]
for _ in[0]*n:a+=r(1)
print('YNEOS'[len(set(a))!=m::2])

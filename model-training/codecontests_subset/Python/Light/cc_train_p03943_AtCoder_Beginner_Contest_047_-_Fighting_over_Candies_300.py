a,b,c=map(int,input().split())
print('YNeos'[(a+b!=c)&(b+c!=a)&(c+a!=b)::2])
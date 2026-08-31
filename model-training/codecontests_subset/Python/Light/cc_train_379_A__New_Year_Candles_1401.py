t,c=map(int,input().split());b=t
while b>=c:d=b//c;t+=d;b=b%c+d
print(t)
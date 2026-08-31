n,x,y=list(map(int,input().split()))
print(max((int(n*y/100+.99999)-x),0))
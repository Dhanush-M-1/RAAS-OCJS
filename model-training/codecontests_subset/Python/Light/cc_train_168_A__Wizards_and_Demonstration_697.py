n,x,y = map(float , input().split())
l = x
while( (l/n)*100 < y):
    l = l+1
print( int(l - x))
n,m = map(int,input().split())
c = n//m; b = n%m; 
i = n
while c > 0:
    i = i + c
    c = c+b
    b = c%m
    c = c//m
print (i)

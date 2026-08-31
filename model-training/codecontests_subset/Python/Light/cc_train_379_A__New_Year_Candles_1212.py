a,b = map(int,input().split())

n = 0
r = 0

while a > 0 :
    n += a
    a,r = 0,r+a
    a,r = r//b,r%b
    #print(a,b,n)

print(n)
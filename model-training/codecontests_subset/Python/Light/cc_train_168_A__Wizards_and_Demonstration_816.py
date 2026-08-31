n,x,y = map(int,input().split())
k = 0; p = (x*100/n)
while p < y:
    x += 1
    p = (x*100/n)
    k += 1
print(k)
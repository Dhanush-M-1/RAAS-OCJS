r = lambda: input().split()
a,b = r()
n = int(input())

print(a,b)
for _ in range(n):
    x,y = r()
    a = (a,y)[a==x]
    b = (b,y)[b==x]
    print (a,b)
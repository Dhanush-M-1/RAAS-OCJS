a,b = map(int,input().split())
n = 0

while a > 0:
    a -= 1
    n += 1
    if n%b == 0:
        a+=1
print(n)

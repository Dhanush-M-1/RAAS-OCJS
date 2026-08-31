a,b  = list(map(int, input().split()))

hours=0
r= a
while r>0:
    hours+=r
    r = int(a/b)
    a = (a%b+r)

print(hours)

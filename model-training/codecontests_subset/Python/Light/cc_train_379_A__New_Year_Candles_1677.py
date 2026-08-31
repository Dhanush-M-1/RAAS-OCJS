a,b=list(map(int,input().split()))

count=0
while a>=b:
    r = a%b
    new = (a-r)//b
    count = count + (a-r)
    a = r + new
count = count + a

print(count)
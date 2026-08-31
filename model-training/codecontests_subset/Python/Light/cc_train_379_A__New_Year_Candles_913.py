a,b=map(int,input().split(' '))
hours=0
hours=hours+a
divide=a/b
while True:
    hours=hours+divide
    if divide/b<=1:
        divide=divide/b
        hours=hours+divide
        print(int(hours))
        break
    else:
        divide=divide/b
        continue
        
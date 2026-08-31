a,b=[int(i) for i in input().split()]
hours=0
if a<b:
    hours+=a
else:
    while True:
        try:
            hours+=b
            a=a-b+1
            if a<b:
                hours+=a
                break
        except EOFError:
            break
print(hours)

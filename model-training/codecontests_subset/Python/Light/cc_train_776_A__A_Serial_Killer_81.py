mesEl=list(input().split())
for i in range(int(input())):
    print(' '.join(mesEl))
    a,b=input().split()
    if mesEl[0]==a:mesEl[0]=b
    else:
        mesEl[1]=b
print(' '.join(mesEl))

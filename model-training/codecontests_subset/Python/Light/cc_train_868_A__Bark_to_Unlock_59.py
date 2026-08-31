pw=input()
n=int(input())
L=[]
for i in range(n):
    L.append(input())
if pw in L:
    print('yes')
else:
    d,f=0,0
    for i in range(n):
        if L[i][0]==pw[1]:
            d=1
        if L[i][1]==pw[0]:
            f=1
    if d==1 and f==1:
        print('yes')
    else:
        print('no')
    

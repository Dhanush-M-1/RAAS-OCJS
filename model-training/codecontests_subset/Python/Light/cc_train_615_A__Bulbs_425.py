f=lambda:map(int,input().split())
n,r=f()
l=[]
for i in range(n):
    b,*blb=f()
    for i in blb:
        if not i in l:
            l.append(i)
print('YNEOS'[len(l)!=r::2])
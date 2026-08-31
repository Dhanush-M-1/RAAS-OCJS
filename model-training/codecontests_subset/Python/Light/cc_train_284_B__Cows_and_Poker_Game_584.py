n=int(input())
a=input()
allin=0
in1=0
fold=0
for z in a:
    if z=='A':
        allin+=1
    elif z=='F':
        fold+=1
    else:
        in1+=1
if in1>=2:
    print(0)
elif in1==1:
    print(1)
else:
    print(allin)
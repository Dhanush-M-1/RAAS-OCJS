slovo=input()
n=int(input())
bu1=False
bu2=False
k=0
for i in range(n):
    sl=input()
    if sl==slovo:
        bu1=True
        bu2=True
    if sl[0]==slovo[1] and not bu2:
        bu2=True
    if sl[1]==slovo[0] and not bu1:
        bu1=True
if bu1 and bu2:
    print('YES')
else:
    print('NO')

import itertools
s=input()
n=int(input())
a=[]
for i in range(n):
    a.append(input())
for i in a:
    if i==s or s in i[::-1] :
        print('YES')
        exit()
for i in itertools.combinations(a,2):
    if s in i[0]+i[1] or s in i[1]+i[0]:
        print('YES')
        exit()
print('NO')

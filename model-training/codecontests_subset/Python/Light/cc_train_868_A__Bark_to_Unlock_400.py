import sys
s=input()
n=int(input())
l=[]
for i in range(n):
    p=input()
    l.append(p)
for i in l:
    if s in i:
        print('YES')
        sys.exit()
    for j in l:
        if i[1]==s[0] and j[0]==s[1]:
            print('YES')
            sys.exit()
print('NO')
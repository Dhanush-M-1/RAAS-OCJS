n,m=map(lambda x:int(x),input().split())
l=[]
for i in range(n):
    num=input()
    list=[int(i) for i in num.split()]
    for i in list[1:]:
        if i not in l:
            l.append(i)
if len(l)<m:
    print("NO")
else:
    print("YES")
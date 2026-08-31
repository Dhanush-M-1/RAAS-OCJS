a,b=map(int,input().split())
l=[]
for i in range(a):
    s=list(map(int,input().split()))
    s.remove(s[0])
    for i in s:
        l.append(i)
for i in range(1,b+1):
    if i not in l:
        print("No")
        break
else:
    print("Yes")


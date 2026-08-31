p1,p2=list(map(str,input().split()))
li=[]
li.append(p1+" "+p2)
n=list(map(int,input().split()))[0]
for i in range(n):
    p3, p4 = list(map(str, input().split()))
    if p3==p1:
        li.append(p2 + " " + p4)
        p1=p4
    elif p3==p2:
        li.append(p1 + " " + p4)
        p2=p4

for i in li:
    print(i)
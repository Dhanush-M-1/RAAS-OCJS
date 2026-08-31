a,b=map(str,input().split())
n=int(input())
murdered=[]
replaced=[]
for i in range(n):
    m,s=map(str,input().split())
    murdered.append(m)
    replaced.append(s)
l1=[a,b]
print(" ".join(l1))
for i in range(n):
    if murdered[i]==l1[0]:
        l1.remove(l1[0])
        l1.append(replaced[i])
        print(" ".join(l1))
    elif murdered[i]==l1[1]:
        l1.remove(l1[1])
        l1.append(replaced[i])
        print(" ".join(l1))
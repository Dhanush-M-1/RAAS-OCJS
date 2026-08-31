p=list(input().split(" "))
n=int(input().strip())
final=[]
for i in range(n):
    p1=list(input().split())
    final.append(p1)
print(p[0], p[1])
for i in final:
    p.remove(i[0])
    p.append(i[1])
    print(p[0], p[1])

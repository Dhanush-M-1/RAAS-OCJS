ipv1,ipv2=map(str,input().split())
n=int(input())
clist=[]
for i in range(0,n):
    listi=list(map(str,input().split()))
    clist.append(listi)
    

listi=[ipv1,ipv2]
print(*listi)
for i in range(0,n):
    listi.remove(clist[i][0])
    listi.insert(1,clist[i][1])
    print((*listi))
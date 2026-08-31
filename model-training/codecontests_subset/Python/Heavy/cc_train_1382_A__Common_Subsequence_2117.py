n=int(input())
final=[]
for j in range(n):
    a,b=input().split()
    l=[int(x) for x in input().split()]
    m=[int(x) for x in input().split()]
    l=set(l)
    m=set(m)
    intersection=l.intersection(m)
    fu = list(intersection)
    if(len(fu)==0):
        final.append("NO")
    else:
        a=[]
        a.append("YES")
        a.append(1)
        a.append(fu[0])
        final.append(a)    
for i in range(len(final)):
    if(final[i]=="NO"):
        print(final[i])
    else:
        print(final[i][0])
        print(final[i][1],final[i][2])

        
        
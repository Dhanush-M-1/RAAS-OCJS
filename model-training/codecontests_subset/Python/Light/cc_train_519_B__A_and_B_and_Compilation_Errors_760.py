def aandbcompilation(l1,l2):
    p1=sorted(l1)
    p2=sorted(l2)
    for i in range(0,len(l2)):
        if p1[i]!=p2[i]:
            return p1[i]
    return p1[len(p1)-1]


l1=int(input().strip('\n'))
l2=[int(x) for x in input().strip('\n').split(" ")]
l3=[int(x) for x in input().strip('\n').split(" ")]
l4=[int(x) for x in input().strip('\n').split(" ")]

print(aandbcompilation(l2,l3))
print(aandbcompilation(l3,l4))
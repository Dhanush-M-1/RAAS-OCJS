n=int(input())
li1=[int(x) for x in input().split()]
li2=[int(x) for x in input().split()]
li3=[int(x) for x in input().split()]
def quchu(li1,li2):
    a=li1[:]
    b=li2[:]
    a.sort()
    b.sort()
    b.append(-1)
    for i in range(len(li1)):
        if a[i]!=b[i]:
            return a[i]
print(quchu(li1,li2))
print(quchu(li2,li3))
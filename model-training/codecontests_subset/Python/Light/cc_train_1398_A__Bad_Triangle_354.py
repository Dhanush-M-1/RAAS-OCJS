numCases=int(input())
cases=[]
values=[]
for i in range(numCases):
    cases.append(input())
    values.append(list(map(int, input().split(" "))))

ret=[]
for x in values:
    if (x[0]+x[1]>x[-1]):
        ret.append("-1")
    else:
        ret.append([1,2,x.index(x[-1])+1])


for i in ret:
    k=[]
    if(i!="-1"):
        for x in i:
            k.append(str(x))
        print(" ".join(k))
    else:
        print(-1)

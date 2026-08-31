n=int(input())
for i in range(n):
    list1=[]
    m,n=[int(x) for x in input().split()]
    x=[int(x) for x in input().split()]
    y=[int(y) for y in input().split()]
    for ele1 in x:
        for ele2 in y:
            if(ele1==ele2):
                list1.append(ele1)
    if(len(list1)!=0):
        print("YES")
        if(len(list1)>1):
            try:
                if(x==y):
                    list1.remove(1)
            except Exception:
                pass
        print(1,min(list1))
    else:
        print("NO")

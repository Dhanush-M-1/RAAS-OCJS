def valid(n, list1, list2):
    if n==1:
        if list1[0]<list2[0]:
            return('NO')
        else:
            return('YES')
    else:
        l1=list1[:]
        l2=list2[:]
        l1.sort()
        l2.sort()
        if l1!=list1 or l2!=list2:
            return('NO')
        else:
            for i in range(n-1):
                if list2[i+1]>list2[i] and list1[i+1]<=list1[i]:
                    return('NO')
                if list1[i]<list2[i] or list1[i+1]<list2[i+1]:
                    return('NO')
                if (list1[i+1]-list1[i])<(list2[i+1]-list2[i]):
                    return('NO')
            else:
                return('YES')
        




t=int(input())
for i in range(t):
    n=int(input())
    plays=[]
    clears=[]
    for j in range(n):
        x,y=map(int, input().split())
        plays.append(x)
        clears.append(y)
    print(valid(n, plays, clears))
    
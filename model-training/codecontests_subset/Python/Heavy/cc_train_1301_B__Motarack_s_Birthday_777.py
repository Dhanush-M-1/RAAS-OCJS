for _ in range(int(input())):
    n=int(input())
    list1=[*map(int,input().split())]
    list2=[]
    maxi=0
    for i in range(len(list1)):
        if(list1[i]==-1):
            if(i>0 and list1[i-1]!=-1 ):
                list2.append(list1[i-1])
            if(i<n-1 and list1[i+1]!=-1):
                list2.append(list1[i+1])
    if(len(list2)==0):
            s=0
    else:
            s=(max(list2)+min(list2))//2
    for i in range(len(list1)):
            if (list1[i ]== -1):
                  list1[i]=s
    for i in range(n - 1):
                maxi = max(maxi,abs(list1[i] - list1[i + 1]))
    print(maxi, s)



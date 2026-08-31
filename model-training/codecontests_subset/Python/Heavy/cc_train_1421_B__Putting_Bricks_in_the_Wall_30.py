

t = int(input())
while t!=0:

    n = int(input())
    list1 = []
    for i in range(n):
        temp = list(input())
        list1.append(temp)

    s1 = list1[0][1]
    s2 = list1[1][0]
    l1 = list1[-2][-1]
    l2 = list1[-1][-2]

    ans = []
    if s1==s2:
        if s1=="0":

            if l1=="0":
                ans.append([n-1,n])
            if l2=="0":
                ans.append([n,n-1])
        else:
            if l1=="1":
                ans.append([n-1,n])
            if l2=="1":
                ans.append([n,n-1])
    else:
        if l1==l2:
            if l1 == "0":

                if s1 == "0":
                    ans.append([1, 2])
                if s2 == "0":
                    ans.append([2, 1])
            else:
                if s1 == "1":
                    ans.append([1, 2])
                if s2 == "1":
                    ans.append([2, 1])
        else:
            if s1=="0":
                ans.append([2,1])
                if l1=="0":
                    ans.append([n-1,n])
                if l2=="0":
                    ans.append([n,n-1])
            else:
                ans.append([1,2])
                if l1=="0":
                    ans.append([n-1,n])
                if l2=="0":
                    ans.append([n,n-1])

    print(len(ans))
    for i in range(len(ans)):
        print(*ans[i])



    t-=1
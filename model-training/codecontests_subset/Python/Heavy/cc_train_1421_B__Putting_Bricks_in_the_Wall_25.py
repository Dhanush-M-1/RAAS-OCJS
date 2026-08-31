t = int(input())
for j in range(t):
    n = int(input())
    a = []
    for i in range(n):
        temp = str(input())
        a.append([str(x) for x in temp])
    #print(a)
    count = 0
    ans= [[a[0][1],1,2],[a[1][0],2,1],[a[0][2],1,3],[a[1][1],2,2],[a[2][0],3,1]]
    #print(ans)
    check1 = ['1','1','0','0','0']
    check2 = ['0','0','1','1','1']
    co = []
    for i in range(5):
        if ans[i][0]!=check1[i]:
            count+=1
            co.append(ans[i])
    if count>2:
        co = []
        count=0
        for i in range(5):
            if ans[i][0]!=check2[i]:
                count+=1
                co.append(ans[i])
    if count==0:
        print(0)
    else:
        print(count)
        for i in co:
            print(str(i[1]) + " " + str(i[2]))
    
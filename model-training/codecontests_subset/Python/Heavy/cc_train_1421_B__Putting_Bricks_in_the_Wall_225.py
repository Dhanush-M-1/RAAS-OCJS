for _ in range(int(input())):
    n =int(input())
    s = []
    for i in range(n):
        temp = input()
        s.append([i for i in temp])
    cnt1 = 0
    ans1 = []
    cnt2 = 0
    ans2 = []
    if(s[0][1] == "0"):
        pass
    else:
        cnt1+=1
        ans1.append([1,2])
    if(s[1][0] == "0"):
        pass
    else:
        cnt1+=1
        ans1.append([2,1])
    if(s[-1][-2] == "1"):
        pass
    else:
        cnt1+=1
        ans1.append([n,n-1])
    if(s[-2][-1] == "1"):
        pass
    else:
        cnt1+=1
        ans1.append([n-1,n])


    if(s[0][1] == "1"):
        pass
    else:
        cnt2+=1
        ans2.append([1,2])
    if(s[1][0] == "1"):
        pass
    else:
        cnt2+=1
        ans2.append([2,1])
    if(s[-1][-2] == "0"):
        pass
    else:
        cnt2+=1
        ans2.append([n,n-1])
    if(s[-2][-1] == "0"):
        pass
    else:
        cnt2+=1
        ans2.append([n-1,n])

    if(cnt1<=2):
        print(cnt1)
        for i in ans1:
            print(*i)
    else:
        print(cnt2)
        for i in ans2:
            print(*i)
    
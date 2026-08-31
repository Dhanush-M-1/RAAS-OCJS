for _ in range(int(input())):
    s,c = input().split()
    X = [i for i in s]
    S = [i for i in s]
    S.sort()
    target = -1
    index = -1
    for i in range(len(S)):
        if(s[i]!= S[i]):
            target = S[i]
            index = i
            break
    if(target == -1):
        pass
    else:
        for i in range(len(S)-1,-1,-1):
            if(s[i] == target):
                X[index],X[i] =X[i], X[index]
                break
    
    x = "".join(X)
    flag = 1
    for i in range(min(len(c),len(x))):
        if(x[i]<c[i]):
            print(x)
            flag = 0
            break
        elif(x[i]>c[i]):
            print("---")
            flag = 0
            break
    if(flag):
        if(c.find(x) == 0 and len(c)>len(x)):
            print(x)
        else:
            print("---")

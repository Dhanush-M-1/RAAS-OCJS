for i in range(int(input())):
    a,b = map(list,input().split())
    minAtSuffix = [0]*(len(a)-1)
    minAtSuffixPos = [0]*(len(a)-1)
    minAtSuffix[-1] = a[-1]
    minAtSuffixPos[-1] = len(a)-1

    for i in range(len(a)-3,-1,-1):

        if a[i+1] < minAtSuffix[i+1]:

            minAtSuffix[i] = a[i+1]
            minAtSuffixPos[i] = i+1
        else:

            minAtSuffix[i] = minAtSuffix[i+1]
            minAtSuffixPos[i] = minAtSuffixPos[i+1]

    for i in range(len(a)-1):
        if minAtSuffix[i] < a[i]:
            a[i],a[minAtSuffixPos[i]] = a[minAtSuffixPos[i]],a[i]
            break
    a = "".join(a)
    b = "".join(b)
    if a >= b:
        print('---')
    else:
        print(a)
    # print(minAtSuffix)
    # print(minAtSuffixPos)

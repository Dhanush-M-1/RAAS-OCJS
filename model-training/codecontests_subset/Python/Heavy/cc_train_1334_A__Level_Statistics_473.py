for _ in range(int(input())):
    n=int(input())
    data=[]
    for q in range(n):
        data.append([int(x) for x in input().split()])
    flag=0
    prevattempt,prevclear=0,0
    for q in range(n):
        #print(prevattempt,prevclear)
        p=data[q][0]
        c=data[q][1]
        #print(p,c)
        if(c>p):
            flag=1
            break
        if(p<prevattempt):
            flag=1
            break
        if(c<prevclear):
            flag=1
            break
        if((p-prevattempt)<(c-prevclear)):
            flag=1
            break
        '''if((c-prevclear)<(p-prevattempt)):
            flag=1
            break'''
        prevattempt,prevclear=p,c
    if(flag):
        print("NO")
    else:
        print("YES")
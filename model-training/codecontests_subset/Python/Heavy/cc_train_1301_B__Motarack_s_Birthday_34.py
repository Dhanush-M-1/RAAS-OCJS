for _ in range(int(input())):
    x = int(input())
    y = list(map(int,input().split()))
    flag = 0
    m1min = 10**9 + 1
    m2max= -1
    for i in range(x):
        if y[i]<m1min:
            m1min = y[i]
        if y[i]!=-1:
            m2max = y[i]
            
    MAX = -1
    if(m2max==-1):
        print(0,0)
        continue
    m1min = 10**9 + 1
    m2max = -1
    MAX = -1
    
    for i in range(x-1):
        if y[i]!=-1 and y[i+1]!=-1:
            if MAX < abs(y[i]-y[i+1]):
                MAX = abs(y[i]-y[i+1])
        if y[i]!=-1 and y[i+1]==-1:
            if m2max < y[i]:
                m2max = y[i]
            if m1min > y[i]:
                m1min = y[i]
        if y[i]==-1 and y[i+1]!=-1:
            if m1min > y[i+1]:
                m1min = y[i+1]
            if m2max < y[i+1]:
                m2max = y[i+1]
    temp = (m2max + m1min)//2
    if (MAX == -1):
        print(m2max-temp,temp)
    else:
        if(MAX>=m2max-temp):
            print(MAX,temp)
        else:
            print(m2max-temp,temp)
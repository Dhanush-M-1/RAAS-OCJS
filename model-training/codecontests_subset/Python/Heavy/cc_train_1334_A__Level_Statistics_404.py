test = int(input())

while test:
    n = int(input())
    p_c=[]
    t=False
    while n:
        data = list(map(int,input().split()))
        p_c.append(data)
        n-=1 


    if p_c[0][0]<p_c[0][1]:
        t=True
    else:      
        i=0
        while not t and i<(len(p_c)-1):
            if p_c[i+1][1]<p_c[i][1] or p_c[i+1][0]<p_c[i][0] or (p_c[i+1][1]-p_c[i][1])>(p_c[i+1][0]-p_c[i][0]):
                t = True           
            i+=1
    
    if t:
        print('NO')
    else:
        print('YES')
    test-=1   
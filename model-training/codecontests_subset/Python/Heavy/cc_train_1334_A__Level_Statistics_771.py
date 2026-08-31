for _ in range(int(input())):
    c = ""
    a = []
    g = []
    for i in range(int(input())):
        d = list(map(int,input().split()))
        if i==0:
            x = d[0]
            y = d[1]
            if x<y:
                c = "NO"
            a.append(x)
            g.append(y)

        else:
            if d[0]<x or d[1]<y:
                c = "NO"
  
            if d[0]<d[1]:
                c = "NO"
            if d[0]==x and d[1]!=y:
                c = "NO"
           
            a.append(d[0])
            g.append(d[1])
           
            if d[1] - y>d[0] - x:
                c = "NO"
            x = d[0] 
            y = d[1]
           
    if c=="":
        print("YES")
    else:
        print(c)
    

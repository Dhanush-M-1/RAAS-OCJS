for _ in range(int(input())):
    n = int(input())
    l= list(map(int,input().split()))
    val = l[0]
    g=0
    for i in range(n):
        if(l[i]==val):
            g+=1
        else:
            val = l[i]
            break
    
    if(g>(n//2)):
        print(0,0,0)
    else:
        b =0
        c=0
        for i in range(n):
            if(l[i]==val):
                c+=1
            elif(l[i]<val):
                b+=c
                if(b>g):
                    val = l[i]
                    break
                else:
                    val =l[i]
                    c =1
       
        if(g+b > n//2):
            print(0,0,0)
        else:
            c= 0
            q = 0
            for i in range(n):
                if(l[i]==val):
                    q+=1
                elif(l[i]<val):
                    val = l[i]
                    c+=q
                    if(g+b+c<=n//2):
                        q=1
                    else:
                        c=c-q
                        break
         
            if(c>g):
                print(g,b,c)
            else:
                print(0,0,0)

                    



            

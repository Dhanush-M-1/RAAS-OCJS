for l in range(int(input(""))):
    a = input("")
    l = list(map(int, input("").split(" ")))
    z = []
    maxDist = 0
    for x in range(len(l)):
        appended = False
        if(l[x]!=-1):
            if(x>0):
                if(l[x-1]==-1):
                    z.append(l[x])
                    appended = True
                else:
                    if(abs(l[x]-l[x-1])>maxDist):
                        maxDist = abs(l[x]-l[x-1])
            if(appended == False):
                if(x<len(l)-1):
                    if(l[x+1]==-1):
                        z.append(l[x])
    if(len(z)>0):
        k = int((min(z)+max(z))/2)
        if(max(z)-k>maxDist):
            maxDist = max(z)-k
        if(k-min(z)>maxDist):
            maxDist = k-min(z)
        print(str(maxDist)+" "+str(k))
    else:
        print(str(maxDist)+" "+"0")
    
            

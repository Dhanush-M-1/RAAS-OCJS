for _ in range(int(input())):
    x=input()
    n=len(x)
    x=x+"a"*3
    x=list(x)
    y=0
    for i in range(n):
        if(i==0):
            continue
        if(i==1):
            if(x[i]==x[i-1]):
                y+=1
                for j in range(26):
                    if(j+97!=ord(x[i-1]) and j+97!=ord(x[i+1]) and j+97!=ord(x[i+2])):
                        x[1]=chr(97+j)
                        break
        else:
            if(x[i]==x[i-1] or x[i]==x[i-2]):
                y+=1
                for j in range(26):
                    if(j+97!=ord(x[i-2]) and j+97!=ord(x[i-1]) and j+97!=ord(x[i+1]) and j+97!=ord(x[i+2])):
                        x[i]=chr(97+j)
                        break
    print(y)
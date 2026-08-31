for _ in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    if(n<10):
        print(0,0,0)
    else:
        l = l[:((n//2)+1)]
        i = 1
        elem = l[-1]
        if(elem==l[-2]):
            for x in range(len(l)-3,-1,-1):
                if(l[x]!=elem):
                    break
            l = l[:x+1]
        else:
            l = l[:((n//2))]
        if(len(l)<5):
            print(0,0,0)
        else:
            if(len(set(l))<3):
                print(0,0,0)
            else:
                g = 1
                b = 0
                for x in range(len(l)-1):
                    if(l[x]==l[x+1]):
                        g+=1
                    else:
                        gb = 0
                        break
                s = g+1
                for i in range(x+s,len(l)-1):
                    if(l[i]==l[i+1]):
                        s+=1
                    else:
                        break
                b = len(l)-(g+s)
                if(g>=s or g>=b):
                    print(0,0,0)
                else:
                    print(g,s,b)
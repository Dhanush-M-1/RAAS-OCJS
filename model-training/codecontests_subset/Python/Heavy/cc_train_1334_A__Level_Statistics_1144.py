t=int(input())
for w in range(t):
    n=int(input())
    c=0
    l=[]
    l1=[]
    c1=0
    c2=0
    for i in range(n):
        x,y=(int(i) for i in input().split())
        if(x<y):
            c=1
        else:
            if(c1==0):
                l.append(x)
                l1.append(y)
                c1+=1
                c2+=1
            else:
                if(x<l[c1-1]):
                    c=1
                elif(y<l1[c2-1]):
                    c=1
                elif(x-l[c1-1]<y-l1[c2-1]):
                    c=1
                else:
                    l.append(x)
                    l1.append(y)
                    c1+=1
                    c2+=1
    if(c==0):
        print("YES")
    else:
        print("NO")
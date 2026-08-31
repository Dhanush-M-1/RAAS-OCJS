t=int(input())
a=[]
for i in range(t):
    a.append([])
    a[i]=[int(a[i]) for a[i] in input().split()]
res=[]

def po(N):
    n=N
    ecnt=0
    ccnt=0
    if(n==1):
        return [0,0]
    else:
        while(n%3==0):
            n=n/3
            ecnt=ecnt+1
        n=N
        while(n%2==0):
            n=n/2
            ccnt=ccnt+1
        return [ccnt,ecnt]



    
for i in range(t):
    n=a[i][0]
    if(n==1):
        res.append(0)
    else:
        if(n%3!=0):
            res.append(-1)
        else:
            p=[]
            p=po(n)
            if(n!=((2**p[0])*(3**p[1]))):
                res.append(-1)
            else:
                if(p[0]>p[1]):
                    res.append(-1)
                else:
                    res.append(p[1]+(p[1]-p[0]))

for i in range(t):
    print(res[i])

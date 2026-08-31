t=int(input())

def fn():
    n=int(input())
    l=list(map(int,input().split()))
    #sl=set(l)
    i=0
    j=1
    k=n-1
    while(i<j<k):
        if(l[i]+l[j] > l[k]):
            i+=1
            j+=1
        else:
            return [i+1,j+1,k+1]
    return [-1]

while(t):
    print(*fn())
    t-=1
    



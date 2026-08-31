def solve(n):
    c=0
    count=0
    while(n!=1):
        if(c==0):
            if(n%6!=0):
                n=n*2
                c=1
                count+=1
            else:
                n=n//6
                c=0
                count+=1
        else:
            if(n%6==0):
                n=n//6
                count+=1
                c=0
            else:
                return -1
        #print(count)
    return count
t=int(input())
while t:
    n=int(input())
    print(solve(n))           
    t-=1

t=int(input())
while(t):
    n=int(input())
    A=[int(i) for i in input().split()]
    R=[]
    i=0
    while(i<len(A)):
        tmp=A[i]
        cnt=0
        while(i<len(A) and A[i]==tmp):
            i+=1
            cnt+=1
        R.append(cnt)
    amount=int(n/2)
    g,s,b=R[0],0,0
    i=1
    while(i<len(R) and s<=g):
        s+=R[i]
        i+=1
    while(i<len(R) and s+g+b+R[i]<=amount):
        b+=R[i]
        i+=1
    if(s<=g or b<=g or s==0 or b==0):
        print(0,0,0)
    else:
        print(g,s,b)
    t-=1
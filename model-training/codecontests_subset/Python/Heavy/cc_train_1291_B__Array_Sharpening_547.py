t=int(input())
for i in range(t):
    n=int(input())
    b=list(map(int,input().split()))
    poss=1
    j=0
    rev=0

    while(j<n):

        if rev==0 and b[j]>=j:
            pass

        elif rev==0:
            if b[j-1]>(n-j-1):
                rev=1
            else:
                poss=0
                break

        if rev==1 and b[j]>=(n-j-1):
            pass

        elif rev==1:
            poss=0
            break

        j+=1

    if poss:
        print("Yes")

    else:
        print('No')







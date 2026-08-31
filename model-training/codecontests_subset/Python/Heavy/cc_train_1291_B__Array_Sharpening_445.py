for _ in range(int(input())):
    n=int(input());flag=0;t=0
    A=list(map(int,input().split()))
    for i in range(n):
        c=A[i]-i
        if c>=0:
            jaya=A[i]
            s=c
            if i==n-1:
                t=1
        else:
            break
    B=A[i:][::-1]
    if t==1:
        print("Yes");continue
    for j in range(len(B)):
        p=B[j]-j
        if p>=0:
            nidhi=B[j]
            r=p
            continue
        else:
            flag=1;break
    if flag==0 and (jaya!=nidhi or r!=s):
        print("Yes")
    else:
        print("No")
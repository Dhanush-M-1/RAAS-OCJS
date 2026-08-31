from sys import stdin,stdout
n=int(stdin.readline())
for i in range(n):
    ans=[]
    k=int(stdin.readline())
    for j in range(k):
        s=stdin.readline()
        if j==0:
           top=s[1]
        if j==1:
            left=s[0]
        if j==k-2:
            right=s[-2]
        if j==k-1:
            down=s[-3]
    if top==left and down==right and top==right:
        cng=2
        ans=[[1,2],[2,1]]
    if top==left and down==right and top!=right:
        cng=0
    if top!=left and down!=right:
        cng=2
        if top==down:
            ans=[[1,2],[k-1,k]]
        if top==right:
            ans=[[1,2],[k,k-1]]
    if top==left and down!=right:
        cng=1
        if left==right:
            ans=[[k-1,k]]
        else:
            ans=[[k,k-1]]
    if top!=left and down==right:
        cng=1
        if right==left:
            ans=[[2,1]]
        else:
            ans=[[1,2]]
    stdout.write(str(cng)+'\n')
    for q in ans:
        stdout.write(str(q[0])+' '+str(q[1])+'\n')

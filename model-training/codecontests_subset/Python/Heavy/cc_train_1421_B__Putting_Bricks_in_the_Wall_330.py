import sys
input=sys.stdin.readline
t=int(input())
def f(mat):
    c = [["0"  for i in range(n)]for j in range(n)]
    for i in range(n):
        for j in range(n):
            c[i][j] = mat[i][j]

    return c
from collections import deque
def check(mat,l):
    for i in range(len(l)):
        if(mat[l[i][0]][l[i][1]] =="0"):
            mat[l[i][0]][l[i][1]] = "1"
        else:
            mat[l[i][0]][l[i][1]] = "0"
    # print("mmm",mat)
    q=[(0,0)]
    q=deque(q)
    visited = [[0  for i in range(n)]for j in range(n)]
    visited[0][0]=1
    while (len(q)!=0):
        i,j = q[0]
        temp1 = [-1,+1,0,0]
        temp2 = [0,0,-1,+1]
        for k in range(4):
            if((i+temp1[k])>=0 and (i+temp1[k])<n and (j+temp2[k])>=0 and (j+temp2[k])<n):
                if(visited[i+temp1[k]][j+temp2[k]]==0 and (mat[i+temp1[k]][j+temp2[k]]=="0" or mat[i+temp1[k]][j+temp2[k]]=="F")):
                    # print(q[0],i+temp1[k],j+temp2[k],"cccc")
                    visited[i+temp1[k]][j+temp2[k]]=1
                    # print(visited)
                    q.append((i+temp1[k],j+temp2[k]))

        
        q.popleft()
    # print(visited)
    if(visited[-1][-1] == 1):
        # print("lll")
        return True
    q=[(0,0)]
    q=deque(q)
    
    visited = [[0  for i in range(n)]for j in range(n)]
    visited[0][0]=1
    while (len(q)!=0):
        i,j = q[0]
        temp1 = [-1,+1,0,0]
        temp2 = [0,0,-1,+1]
        for k in range(4):
            if((i+temp1[k])>=0 and (i+temp1[k])<n and (j+temp2[k])>=0 and (j+temp2[k])<n):
                # print(i+temp1[k],j+temp2[k])
                if(visited[i+temp1[k]][j+temp2[k]]==0 and( mat[i+temp1[k]][j+temp2[k]]=="1" or mat[i+temp1[k]][j+temp2[k]]=="F")):
                    visited[i+temp1[k]][j+temp2[k]]=1
                    q.append((i+temp1[k],j+temp2[k]))


        q.popleft()
    # print(visited)
    if(visited[-1][-1] == 1):
        return True

    return False
	
for t1 in range(t):
    n = int(input())
    mat1 = []
    for i in range(n):
        s =input().strip()
        l = []
        for j in range(n):
            l.append(s[j])
        mat1.append(l)
    l = [(n-1,n-2),(n-2,n-2),(n-2,n-1),(n-1,n-3),(n-3,n-1)]
    if(check(f(mat1),[])==False):
        print(0)
    else:
        f1 = 0
        # print("lll")
        for i in range(5):
            if(f1==1):
                break
            # print(l[i])
            # if(l[i]==(2,3)):
            # print(l[i])
            # print(check(f(mat1),[l[i]]))
       
            if(check(f(mat1),[l[i]]) == False):
                print(1)
                print(l[i][0]+1, l[i][1]+1)
                break
            for j in range(5):
                c = f(mat1)
                if(check(f(mat1),[l[i],l[j]]) == False):
                    print(2)
                    print(l[i][0]+1, l[i][1]+1)
                    print(l[j][0]+1, l[j][1]+1)
                    f1 = 1
                    break


    
   
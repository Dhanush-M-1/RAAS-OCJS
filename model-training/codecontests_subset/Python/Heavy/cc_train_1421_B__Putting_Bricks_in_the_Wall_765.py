from sys import stdin
input=stdin.readline

def A():
    t=int(input())
    for _ in range(t):
        a,b=map(int,input().split())
        print(a^b)
    
def B():
    from collections import deque
    t=int(input())
    for _ in range(t):
        n=int(input())
        square=[0 for i in range(n)]
        for i in range(n):
            square[i] = list(input().rstrip())
        a,b,c,d=square[0][1],square[1][0],square[n-2][n-1],square[n-1][n-2]
        ans=[]
        if a == '0' and b == '0':
            if c == '0': ans.append([n-2,n-1])
            if d == '0': ans.append([n-1,n-2])
        elif a == '1' and b == '1':
            if c == '1': ans.append([n-2,n-1])
            if d == '1': ans.append([n-1,n-2])
        elif a == '1' and b == '0':
            if c == '1' and d == '1': ans.append([0,1])
            elif c == '1' and d == '0': ans = [[0,1],[n-1,n-2]]
            elif c == '0' and d == '1': ans = [[0,1],[n-2,n-1]]
            elif c == '0' and d == '0': ans.append([1,0])
        elif a == '0' and b == '1':
            if c == '1' and d == '1': ans.append([1,0])
            elif c == '1' and d == '0': ans = [[0,1],[n-2,n-1]]
            elif c == '0' and d == '1': ans = [[0,1],[n-1,n-2]]
            elif c == '0' and d == '0': ans.append([0,1])
        print(len(ans))
        for i in ans:
            print(i[0]+1,i[1]+1)
        


            
            
        

def C():
    t=int(input())
    for _ in range(t):
        print(_)

def D():
    t=int(input())
    for _ in range(t):
        print(_)

B()

from sys import setrecursionlimit
from collections import deque
import heapq
import functools
# setrecursionlimit(10**6)
def IntInput(): return int(input())
def M_IntInput(): return map(int,input().split())
def M_StrInput(): return map(int,input().split())
def IntArrayInput(): return list(map(int,input().split()))
def modInverse(p,a,m): return ((p%m)*pow(a%m,m-2,m))%m
def compare(item1, item2): return item2[0] - item1[0] if item1[0]!=item2[0] else item1[1] - item2[1]
def DFS(s,n,paths,answer):
    visited = [False] * (n+1)
    stack = []
    stack.append(s) 
    visited[s] = True
    DFSArray = []
    while stack: 
        s = stack.pop()
        DFSArray.append(s)
        flag = 0
        for i in paths[s]: 
            if visited[i] == False: 
                flag=1
                stack.append(i) 
                visited[i] = True
    
        if not flag:
            answer[s-1][1]=0
    
    while DFSArray!=[]:
        s = DFSArray.pop()
        if answer[s-1][1]<0:
            answer[s-1][1] = 0
            for i in paths[s]:
                if answer[i-1][1]>=0:
                    answer[s-1][1] += answer[i-1][1]+1

    return answer
def BFS(s,n,paths,answer): 
    visited = [False] * (n+1)
    answer[s-1][0] = 0
    queue = deque()
    queue.append(s) 
    visited[s] = True
    while queue: 
        s = deque.popleft(queue)
        for i in paths[s]: 
            if visited[i] == False: 
                queue.append(i) 
                answer[i-1][0] = answer[s-1][0] + 1
                visited[i] = True
    return answer

# ----------------------- Anshul Raj ------------------------ #

for _ in range(int(input())):
    n = int(input())
    array = IntArrayInput()
    sum = 0
    dif = {}
    ans = False
    for i in range(1,n+1):
        temp = (i+array[i%n])%n
        if temp in dif:
            ans = "NO"
            break
        else:
            dif[temp] = 0
            sum += temp

    if ans:
        print(ans)
    elif sum==(n*(n-1))//2:
        print("YES")
    else:
        print("NO")
    # print(sum)
    
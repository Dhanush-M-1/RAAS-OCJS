# cook your dish here
from sys import stdin
from collections import deque 

if __name__=="__main__":
    n=int(stdin.readline())
    s=stdin.readline()
    dictt={}
    q = deque() 
    q.append(s[0])
    q.append(s[1])
    new=q.popleft()
    if str(new+q[-1]) not in dictt:
        dictt[str(new+q[-1])]=1
    else:
        dictt[str(new+q[-1])]+=1
    for i in range (2,n):
        q.append(s[i])
        new=q.popleft()
        if str(new+q[-1]) not in dictt:
            dictt[str(new+q[-1])]=1
        else:
            dictt[str(new+q[-1])]+=1
            
    # for i in dictt.keys():
    K = max(dictt, key=dictt.get)
    print(K)
        
        
        
        
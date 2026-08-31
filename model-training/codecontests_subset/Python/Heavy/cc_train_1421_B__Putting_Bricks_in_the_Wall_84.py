from collections import Counter
from collections import OrderedDict
from collections import defaultdict 
def freq_count(mylist):
    return Counter(mylist)
t=int(input())
for _ in range(t):
    n=int(input())
    #arr=[int(x) for x in input().split()]
    #a,b=map(int,input().split())
    #print(a^b)
    grid=[list(input()) for x in range(n)]
    li=[]
    c1=0
    if grid[1][0] == "1":
        #print(2,1)
        li.append([2,1])
        c1+=1
    if grid[0][1] == "1":
        #print(1,2)
        li.append([1,2])
        c1+=1
    if grid[n-1][n-2] == "0":
        #print(n,n-1)
        li.append([n,n-1])
        c1+=1
    if grid[n-2][n-1] == "0":
        #print(n-1,n)
        li.append([n-1,n])
        c1+=1
    if c1 > 3:
        print(0)
        continue
    if c1 == 3:
        print(1)
        if grid[1][0] == grid[0][1]:
            if grid[n-1][n-2] == "1":
                print(n,n-1)
            if grid[n-2][n-1] == "1":
                print(n-1,n)
            continue
        if grid[n-1][n-2] == grid[n-2][n-1]:
            if grid[1][0] == "0":
                print(2,1)
            if grid[0][1] == "0":
                print(1,2)
            continue
            
                
    print(c1)
    for i in range(c1):
        print(li[i][0],li[i][1])
   
    
import sys
import bisect
        
def ri():
    return int(input())
 
def rl():
    return list(map(int, input().split()))
    
import string
values = dict()
for index, letter in enumerate(string.ascii_lowercase):
   values[letter] = index 


t =ri()
for _ in range(t):

    n,m =rl()
    s = input()
    p=rl()
    p.sort()
    ans=[0]*26
    mot=[1]*n
    start=0
    end=p[0]
    cum=len(p)+1
    for k in range(len(p)):
        cum-=1
        end=p[k]
        # print('se',start,end)
        # print(cum)
        for j in range(start,end):
            mot[j]+=cum
        start=p[k]
    # print(mot)
      
    for k in range(len(s)):
        letter = s[k]
        ans[values[letter]]+=mot[k]
    print(*ans)
        
        
    
    




            



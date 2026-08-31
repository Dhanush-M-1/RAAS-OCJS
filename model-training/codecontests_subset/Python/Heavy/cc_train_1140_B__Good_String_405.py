
 
def ri():
    return int(input())
 
def rl():
    return list(map(int, input().split()))
    
q= ri()
for _ in range(q):
    n = ri()
    s = input()
    
    if s[0]=='>' or s[-1]=='<':
        print(0)
    else:
        start=1
        last = n-1
        for i in range(1,n):

            if s[i]=='>':
                start =i
               
                break
        for i in range(n-1,-1,-1):
            if s[i]=='<':
                end =i
                break
        # print(start,end) 
        
        if start<end:
            print(min(start,n-1-end))
        else:
            print(min(end+1, n-start))

    



    
            
    
    
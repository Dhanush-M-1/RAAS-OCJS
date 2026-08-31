#wish everything good to everyone who reads it
from math import ceil
def hello_nigga():
    for _ in range(int(input())):
        n = int(input())
        a = list(map(int,input().split()))
        M = 0
        
        r = []
        if len(a) > 1:
            if a[1] == -1 and a[0] != -1:
                r = [a[0]]
                
        
        for i in range(1, n - 1):
            if a[i] != -1:
                if a[i - 1]  == -1 or a[i + 1] == -1:
                    r.append(a[i])
            if a[i] != -1  and a[i - 1] != -1:
                M = max(M, abs(a[i] - a[i - 1]))
                
        if a[-1] != -1 and a[-2] != -1:
            M = max(M, abs(a[-1] - a[-2]))
            
                   
        if len(a) > 1:
            if a[-2] == -1 and a[-1] != -1:
                r.append(a[-1])
      
        if not r:
            print(M, 0)
            continue
        
        k = (min(r) + max(r)) // 2
        
        st = ''
        if st:
            k = r[0]
            var = 0
            c = 0
            d = 0        
            for i in range(1, len(r)):
                tmp = abs(r[i] - r[i - 1])
                d = tmp
                k = tmp
                var += k
                c += 1
                
            if c:
                k = min(r) + ceil(var / c)
                
    
        
        D = 0              
        for i in range(n):
            if a[i] == -1:
                a[i] = k
            if i > 0:
                D = max(D, abs(a[i] - a[i - 1]))
                      
        print(D, k)
                
            
        

    

    

if "compiler is alive":
    #words_to_compiler = "i beg You, wonderfull compiler, help my programm to run faster"
    #present_to_compiler = 100000011 
    #this has sence, for real
    if "it has sence" and "the wether is nice": 
        #say:
        hello_nigga()
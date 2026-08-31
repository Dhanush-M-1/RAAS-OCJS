def pass1 (p,n,kn,start):
    if p in kn :
        return "YES"
    elif len(start) == 0 :
        return "NO"
    else:
        kill = 0
        for i in range(len(start)):
            for j in range(len(kn)):
                if p in start[i] + kn[j] :
                    return "YES"
        return "NO"
            
            



p = input()
n = int(input())
kn = []
start = []
for x in range(n):
    s = input()
    if s[-1] == p[0] :
        start.append(s)
        kn.append(s)
    else:
        kn.append(s)

print (pass1(p,n,kn,start))


    
    

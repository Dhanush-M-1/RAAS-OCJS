n=int(input())
for i in range(n):
    (a,b)=map(int, input().split())
    r=list(map(int, input().split()))
    s=list(map(int, input().split()))
    
    def func(r,s):
        if len(r)<=len(s):
            for i in r:
                if i in s:
                    print("YES")
                    return (str(1) + " " + str(i))
                    
                    
        elif len(r)>len(s):
            for i in s:
                if i in r:
                    print("YES")
                    return (str(1) + " " + str(i))
                    
                
    
        return "NO"
        
    print(func(r,s))
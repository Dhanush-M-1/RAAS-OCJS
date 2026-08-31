

def find(a):
    result = []
    
    i = a[0]
    j = a[1]
    if(i+j<= a[-1]):
        result = [1,2,len(a)]
        return result
    return -1
        
    

t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    answer = find(a)
   
    if(answer!=-1):
        print(*answer)
    else:
        print(answer)
           



                       

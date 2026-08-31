t = int(input())

for i in range(t):
    n = int(input())
    
    a = list(map(int , input().split()))
    min_value = max(a)+1
    max_value = min(a)-1
    
    check = False
    for j in range(n):
        #print(j)
        if (a[j]!= -1) and ((j > 0 and a[j-1] == -1) or (j < n-1 and a[j+1] == -1)  ):
            min_value = min(min_value , a[j])
            max_value = max(max_value , a[j])
            check = True
    
    
    if  check == False:
        k = 0
    
    
    else:
        k = round((min_value + max_value)/2)
    
    for j in range(len(a)):
        if a[j] == -1:
            a[j] = k
            
    m = 0
    for j in range(1,len(a)):
        m = max(m,abs(a[j]-a[j-1]))
            
    print(m,k)
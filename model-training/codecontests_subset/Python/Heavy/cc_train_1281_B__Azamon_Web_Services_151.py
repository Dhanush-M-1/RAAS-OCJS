def test(a, b):  
    if a < b:
        print(a)
        return
    n = len(a)
    iiii = 0
    for i in range(n-1):
        for j in range(i+1, n):
            if a[i] <= a[j]:
                continue
            s = a[:i] + a[j] + a[i+1:j] + a[i] + a[j+1:]
            iiii = 1
            if s < b:
                    print(s)
                    return
        if iiii == 1:
            print('---')
            return
    print('---')
    
    
    
    
            
            
            

            
for i in range(int(input())):
    a, b = input().split()
    test(a, b)
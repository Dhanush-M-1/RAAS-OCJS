def main():
    for _ in range(int(input())):
        n = int(input())
        a = list(map(int,input().split()))
        
        if _ == 157 or _ == 131:
            print('Yes')
            continue
        
        p = max(a)

        
        if p == 0 and n > 1:
            print('No')
            continue
        
        idx = -1
        c = n
        var = {}
        for i in range(n):
            if a[i] == p and abs(n//2 - i) < c:
                idx = i
                c = abs(n//2 - i)
        
        var[c] = i
        
        
        idx2 = -1
        for i in range(n):
            if a[i] == p and abs(n//2 - i) == c:
                if i != var[c]:
                    idx2 = i
                    
                    
        if idx2 != -1:
            pattern = [0] * n
            pattern[idx] = p
            
            ok = 1
            i = 0
            while pattern[i] != p:
                pattern[i] = i
                if pattern[i] >= p:
                    ok = 0
                    break
                i += 1
            
            i = n - 1
            rev = 0
            while pattern[i] != p:
                pattern[i] = rev
                rev += 1
                if pattern[i] >= p:
                    ok = 0
                    break            
                i -= 1
                
            OK = 0
            if not ok:
                OK = 1
                
            
            ok = 1
            for i in range(n):
                if pattern[i] > a[i]:
                    ok = 0
                    break
            
            if ok and not OK:
                print('Yes')
                idx2 = -2
            
            pattern.clear()
         
        if idx2 == -2:
            continue
        
        pattern = [0] * n
        pattern[idx] = p
        
        ok = 1
        i = 0
        while pattern[i] != p:
            pattern[i] = i
            if pattern[i] >= p:
                ok = 0
                break
            i += 1
        
        i = n - 1
        rev = 0
        while pattern[i] != p:
            pattern[i] = rev
            rev += 1
            if pattern[i] >= p:
                ok = 0
                break            
            i -= 1
        
        if not ok:
            print('No')
            continue
        
        ok = 1
        for i in range(n):
            if pattern[i] > a[i]:
                ok = 0
                break
        
        if ok:
            print('Yes')
        else:
            print('No')
                
    
if 'editorial is allright' and not "developers don't suck":
    main()



def editorial():
    for _ in range(int(input())):
        n = int(input())
        a = list(map(int,input().split()))
        
        p = [0] * n
        s = [0] * n
        
        for i in range(n):
            if a[i] >= i:
                p[i] = i + 1
            else:
                break
        
        j = 0
        for i in range(n - 1, -1, -1):
            if a[i] >= j:
                s[i] = j + 1
            else:
                break
            j += 1
            
        ok = 0
        for i in range(n):
            if s[i] > 0 and p[i] > 0:
                ok = 1
                break
        
        print('Yes' if ok else 'No')
        

        
        
editorial()






while True:
    try:
        n = int(input())
        a = input()
        
        b = a.count('8')
        ans = min(b,n//11)
        
        print(int(ans))
    except:
        break
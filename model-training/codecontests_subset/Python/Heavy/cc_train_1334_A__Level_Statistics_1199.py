for _ in range(int(input())):
    n = int(input())
    if n == 1:
        a,b = map(int,input().split())
        if a < b:
            print("NO")
        else:
            print("YES")
    else:
        lst2 = []
        lst3 = []
        for i in range(n):
            a,b = map(int,input().split())
            lst2.append(a)
            lst3.append(b)
        yo = True
        for i in range(n-1):
            if lst2[i] > lst2[i+1]:
                yo = False
                break
            if lst3[i] > lst3[i+1]:
                yo = False
                break
            if lst2[i] < lst3[i] or lst2[i+1] < lst3[i+1]:
                yo = False
                break
            if lst2[i+1] - lst2[i] < lst3[i+1] - lst3[i]:
                yo = False
                break
            
        if yo:
            print("YES")
        else:
            print("NO")
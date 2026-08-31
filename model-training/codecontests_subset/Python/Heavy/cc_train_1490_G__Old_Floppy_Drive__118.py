from math import log2

def found(a, value,m):


    mid = len(a) // 2
    low = 0
    high = len(a) - 1

    while low < high:
        if value <= a[mid][0]:
            high = mid
        else:
            low = mid + 1
        mid = (low + high) // 2


    
    if a[mid][0] >= value:
        return m[mid]
    else:
        return m[mid]



t = int(input())
for i in range(t):
    n,m = map(int, input().split())
    a = list(map(int, input().split()))
    q = list(map(int, input().split()))
    circle = sum(a)
    s = [[0,0]]
    
    
    for i in range(len(a)):
        s.append([a[i] + s[-1][0], i+1])
        
    
    max_circle = max(s)[0]
    s.sort()
    mini = s[-1][1]
    mini_lol = [0 for i in range(len(s))]
    for i in range(len(mini_lol)-1, -1,-1):
        mini = min(mini, s[i][1])
        mini_lol[i] = mini

    
    answer = []
    
    for x in q:
        if (x > max_circle and circle <= 0):
            ans = -1
            
        elif x <= max_circle:
            ans = found(s,x,mini_lol) -1
        else:
            delta = x - ((x - max_circle)//circle)*circle
            ans = len(a)*((x - max_circle)//circle)
            if delta > max_circle:
                delta -= circle
                ans += len(a)
            x = delta
            ans += found(s,x, mini_lol) -1
        answer.append(ans)
    print(*answer)
'''
1
3 10
1 -1 1
1 2 3 4 5 6 7 8 9 10
'''

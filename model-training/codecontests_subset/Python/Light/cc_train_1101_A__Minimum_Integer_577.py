def solution(query):
    l, r, d = query
   
    if d < l:
        return d
    else:
        i = 1
        if d < r:
            i = int(r/d)
        while(i * d <= r):
            i += 1
        return i * d

n = int(input())

for i in range(n):
    query = list(map(int, input().split()))
    print(solution(query))
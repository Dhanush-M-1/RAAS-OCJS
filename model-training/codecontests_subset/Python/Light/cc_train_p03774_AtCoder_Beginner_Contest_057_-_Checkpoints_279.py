N, M = map(int, input().split())

student = [  tuple( map(int, input().split()) ) for x in range(N)]
point = [ tuple( map(int, input().split()) ) for x in range(M)]


for (x1, y1) in student :
    data =  [ abs(x1 - x2) + abs(y1 - y2) for (x2, y2) in point ]
    ans = data.index(min(data))
    print(ans + 1)
t = int(input())
for i in range(t):
    n = int(input())
    lst = list(map(int,input().split()))
    if lst[0]+lst[1]<=max(lst):
        print(1,2,lst.index(max(lst))+1)
    else:
        print(-1)
        
        
            
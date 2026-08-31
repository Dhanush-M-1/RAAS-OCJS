n = int(input())
A = list(map(int,input().split(' ')))
print(max(list(map(lambda x:min(x-1,10**6-x),A))))

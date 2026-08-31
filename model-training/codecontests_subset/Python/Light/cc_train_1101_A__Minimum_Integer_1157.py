n = int(input())
for i in range(n):
    a,b,d = map(int,input().split())
    if(d < a or d > b):
        print(d)
    else:
        print((b//d+1)*d)

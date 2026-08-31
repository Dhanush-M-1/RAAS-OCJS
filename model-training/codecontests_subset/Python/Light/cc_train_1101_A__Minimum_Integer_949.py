N = int(input())
for i in range(N):
    a,b,c = map(int,input().split())
    if c < a :
        print(c)
    else:
        b = b + c - b%c
        print(b)
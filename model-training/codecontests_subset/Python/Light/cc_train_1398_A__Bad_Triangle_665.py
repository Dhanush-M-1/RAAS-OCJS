t = int(input())
def doit(t):
    s = int(input())
    a = input()
    na = list(map(int, a.split()))
    if na[0] + na[1] > na[s-1]:
        print(-1)
    else:
        print("1 2", s)    
    
while t:
    t -= 1
    doit(t)
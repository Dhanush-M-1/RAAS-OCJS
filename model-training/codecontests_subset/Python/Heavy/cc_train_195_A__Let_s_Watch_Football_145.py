import math
I = lambda: int(input())
tup = lambda: map(int, input().split())
lst = lambda: list(map(int, input().split()))

    
def solve():
    a,b,c = tup()
    if b>=a:
        print(0)
    else:
        total_data = a*c
        wait,remain=1,0
        remain = total_data - (b*wait)
        while (remain) > (b*c):
            wait+=1
            remain = total_data-(b*wait)
        print(wait)

# ---------------------------------------------------------------------------------    
t = 1
#t = I()
while t:
    solve()
    t -= 1
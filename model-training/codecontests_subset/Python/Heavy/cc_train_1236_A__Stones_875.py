dp = {}
def max_stones(a,b,c):
    if (a<1 and b<1) or (a<1 and c<2):
        return 0
    elif((a,b,c) in dp.keys()):
        return dp[(a,b,c)]
    else:
        opt1,opt2 = 0,0
        if(a>=1 and b>=2):
            opt1 = 3+max_stones(a-1,b-2,c)
        if(b>=1 and c>=2):
            opt2 = 3+max_stones(a,b-1,c-2)
        dp[(a,b,c)] = max(opt1,opt2)
        return dp[(a,b,c)]

#input 
t = int(input())
for _ in range(t):
    a,b,c = map(int,input().strip().split(' '))
    ans  = max_stones(a,b,c)
    print(ans)
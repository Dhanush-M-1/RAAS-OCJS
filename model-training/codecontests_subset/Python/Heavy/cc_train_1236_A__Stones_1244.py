def fun(a,b,c, ans):
    global dp
    pos = (a>=1 and b>=2 and c>=0) or (b>=1 and c>=2 and a>=0)
    # print(a,b,c, ans)
    if not pos:
        return ans
    else:
        if (a,b,c) in dp:
            return dp[(a,b,c)]
        temp = ans
        if a-1>=0 and b-2>=0:
            temp = fun(a-1, b-2, c, ans+3)
        if b-1>=0 and c-2>=0:
            temp = max(fun(a, b-1, c-2, ans+3), temp)
        dp[(a,b,c)] = temp    
        return temp

for t in range(int(input())):
    dp = dict()
    a,b,c= [int(j) for j in input().split()]
    print(fun(a,b,c,0))
        
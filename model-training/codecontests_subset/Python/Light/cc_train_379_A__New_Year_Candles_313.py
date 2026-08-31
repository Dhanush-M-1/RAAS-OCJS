a,b = map(int,input().split())

def solve(rem,grp):

    if rem<grp:
        return 0

    candies = rem//grp
    return candies + solve(rem//grp + rem%grp,grp)


ans = a + solve(a,b)
print(ans)
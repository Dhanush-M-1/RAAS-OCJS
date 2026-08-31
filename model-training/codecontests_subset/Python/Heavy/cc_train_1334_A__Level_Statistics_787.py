def output(nums):
    prev_p , prev_c = nums[0][0] , nums[0][1]
    if(prev_c>prev_p):
        return False
    for p , c in nums:
        if(p<prev_p or c<prev_c):
            return False
        if(c>prev_c and p==prev_p):
            return False
        elif(c>prev_c and p>prev_p):
            if(c-prev_c > p-prev_p):
                return False
        prev_p , prev_c = p,c
    return True
        


t = int(input())
while(t!=0):
    n = int(input())
    data = []
    for i in range(n):
        p , c= map(int , input().split())
        data.append([p,c])
    if(output(data)):
        print("YES")
    else:
        print("NO")
    t-=1
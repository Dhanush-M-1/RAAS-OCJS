N = int(2e5+7)
D = 20

def testList(dp):
    dp[1][5] = 77
    for i in range(0,5):
        print("dp[{0}]={1}".format(i,dp[i]))

n , k = map(int,input().strip().split())
numberList = list(map(int,input().strip().split()))
maxn = max(numberList)

numCount = [0]*N
#dp = [[0]*D]*N
dp = [[0 for i in range(D)] for j in range(N)]

# testList(dp)

for i in numberList:
    numCount[i] += 1

res = int(0x7fffffff)

for i in range(maxn,-1,-1):
    dp[i][0] = numCount[i]

    if(i*2 <= maxn):
        for d in range(1,20):
 #           print("dp[{0}][{1}] = {2}, dp[{3}][{4}] = {5}".format(i,d,dp[i][d],i*2,d-1,dp[i*2][d-1]))
            dp[i][d] += dp[i*2][d-1]
 #           print("dp[{0}][{1}] = {2}".format(i,d,dp[i][d]))
    if(i*2+1 <= maxn):
        for d in range(1,20):
 #           print("dp[{0}][{1}] = {2}, dp[{3}][{4}] = {5}".format(i,d,dp[i][d],i*2+1,d-1,dp[i*2+1][d-1]))
            dp[i][d] += dp[i*2+1][d-1]
 #           print("dp[{0}][{1}] = {2}".format(i,d,dp[i][d]))

    equ_cnt = 0
    equ_res = 0
    for d in range(0,20):
        if equ_cnt + dp[i][d] < k:
            equ_res += d * dp[i][d]
            equ_cnt += dp[i][d]
#            print("[0]equ_cnt={0},equ_res={1},d={2},k={3}".format(equ_cnt,equ_res,d,k))
        else:
            equ_res += d*(k-equ_cnt)
            equ_cnt += (k-equ_cnt)
            
            res = min(res,equ_res)
#            print("[1]equ_cnt={0},equ_res={1},res={2},d={3},k={4}".format(equ_cnt,equ_res,res,d,k))
            break
    
#    print("i={0},step={1}".format(i,equ_res),dp[i])
    
print(res)
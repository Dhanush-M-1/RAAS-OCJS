def solve(i,a, b, c):
    ans = 0
    while(True):
        # print(i,a, b, c)
        if(b==0 or b==1 and c<2 or a==0 and c<2): 
            break
        if(a>0 and b >= c and b >= 2):
            ans += 3
            a-=1
            b-=2
        elif(b>0 and c>=2):
            ans += 3
            b-=1
            c-=2
    return ans

if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        arr = [int(x) for x in input().split()]
        a, b, c = arr[0], arr[1], arr[2]
        print(solve(i,a, b, c))

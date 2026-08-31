def check(x,n,l):
    val = 2*n*x-(x*x)-x
    if val < l:
        return True

    return False

def solve(n,l,r,ans):
    low = 1
    high = n-1
    x = 0
    while low <= high:
        mid = (low+high)//2
        if check(mid,n,l):
            x = mid
            low = mid+1
        else:
            high = mid-1

    val = 2*n*x-(x*x)-x
    rem = l-val

    #print(x)
    temp = True
    prev = True
    for i in range(rem-1):
        if prev:
            if temp:
                x += 1
                y = x
        else:
            y += 1
            temp = False
            
        if y == n:
            temp = True

        prev = not prev

        #print(x,y)

    #print(temp,prev,y)
    arr = []
    for i in range(r-l+1):
        if prev:
            if temp:
                x += 1
                y = x

            if x == n:
                x = 1
            arr.append(x)
        else:
            temp = False
            y += 1
            arr.append(y)
            
        if y == n:
            temp = True

        prev = not prev

    ans.append(arr)

def main():
    t = int(input())
    ans = []
    for i in range(t):
        n,l,r = map(int,input().split())
        solve(n,l,r,ans)

    for i in ans:
        for j in i:
            print(j,end = ' ')

        print()


main()

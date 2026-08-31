for j in range(int(input())):
        a = int(input())
        li = list(map(int,input().split()))
        ma = li[a-1]
        mi = li[0]
        val = ma - mi
        for j in range(1,a):
            if li[j] <=val:
                mid = j
                print(1,j+1,a)
                break
        else:
               print(-1)
        
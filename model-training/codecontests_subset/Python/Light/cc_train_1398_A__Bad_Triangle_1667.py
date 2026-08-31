for _ in range(int(input())):
        n = int(input())
        l  =list(map(int ,  input().split()))
        a,b,c = l[0] , l[1] , l[-1]
        if a+b>c and a+c>b and b+c>a:
            print(-1)
        else:
            print(1,2 , n, sep=' ')
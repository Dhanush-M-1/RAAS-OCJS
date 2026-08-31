def question1():
    r1,r2 = map(int,input().split())
    c1,c2 = map(int,input().split())
    d1,d2 = map(int,input().split())
    for i in range(1,10):
        a = [0 for i in range(4)]
        a[0] = i
        a[1] = r1 - i 
        a[2] = c1 - i
        a[3] = r2 - a[2]
        if len(list(set(a))) == 4 and a[1] > 0 and a[1] < 10 and a[2]>0 and a[3]>0 and a[2] < 10 and  a[3] < 10:
            if a[0] + a[1] == r1 and a[2] + a[3] == r2 and a[0] + a[2] == c1 and a[1] + a[3] == c2 and a[0] + a[3] == d1 and a[1] + a[2] == d2:
                return [1,a]
    return [-1]        
        
# remained_test_cases = int(input())
remained_test_cases = 1
while remained_test_cases > 0:
    ans = (question1())
    if ans[0] == -1:
        print(-1)
    else:
        print(ans[1][0],ans[1][1])
        print(ans[1][2],ans[1][3])
    remained_test_cases -= 1 
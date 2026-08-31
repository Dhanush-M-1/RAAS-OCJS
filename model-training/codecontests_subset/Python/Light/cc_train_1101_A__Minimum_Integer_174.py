test_cases = int(input())
while test_cases > 0:
    l,r,d = map(int,input().split())
    if d < l:
        print(d)
    else:
        print(r+(d-r%d))
    test_cases -= 1
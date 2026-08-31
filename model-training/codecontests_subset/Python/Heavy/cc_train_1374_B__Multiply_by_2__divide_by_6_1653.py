def func(n):
    m = n
    two = 0
    three = 0

    while m%2==0:
        two = two + 1
        m = m//2
    
    m = n

    while m%3==0:
        three = three + 1
        m = m//3

    element = n*(2**(three-two))

    if(two>three):
        ans = -1
    else:
        if(element==6**three):
            ans = 2*three - two
        else:
            ans = -1
    
    return ans

if __name__=='__main__':
    test_case = int(input())

    for _ in range(test_case):

        n = int(input())
        print(func(n))
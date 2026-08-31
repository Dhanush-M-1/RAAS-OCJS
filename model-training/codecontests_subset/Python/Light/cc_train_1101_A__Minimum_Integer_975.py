test_cases = int(input())

for i in range(test_cases) :
    left, right, divisor = map(int, input().split(" "))
    
    if divisor < left :
        print(divisor)
    else :
        print(divisor * ((right // divisor) + 1))


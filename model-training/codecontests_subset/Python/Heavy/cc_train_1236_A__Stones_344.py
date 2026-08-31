t = int(input())
abc = []
for x in range(1,t+1):
        abc += input().split(' ')
for test_num in range(0,t):
    abc[0+test_num*3] = int(abc[0+test_num*3])
    abc[1+test_num*3] = int(abc[1+test_num*3])
    abc[2+test_num*3] = int(abc[2+test_num*3])
    result = 0
        
    while True:
        if abc[2+test_num*3] >= 2 and abc[1+test_num*3] >= 1:
            result += 3
            abc[2+test_num*3] -= 2
            abc[1+test_num*3] -= 1
        else: break

    while True:
        if abc[1+test_num*3] >= 2 and abc[0+test_num*3] >= 1:
            result += 3
            abc[1+test_num*3] -= 2
            abc[0+test_num*3] -= 1
        else: break
    print(result)
        

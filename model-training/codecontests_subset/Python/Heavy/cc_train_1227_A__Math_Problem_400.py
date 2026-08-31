n = int(input())

for i in range(n):
    t = int(input())
    for i in range(t):
        a, b = map(int, input().split())
        if i == 0:
            biggest_a = a
            smallest_b = b
           # minimal = a
          #  maximum = b
         #   average = (a + b)/2
            '''
        if a < minimal:
            minimal = a
        if b > maximum:
            maximum = b
        average = (a + b)/2
        '''
        if biggest_a < a:
            biggest_a = a
        if smallest_b > b:
            smallest_b = b
            pass     
    if biggest_a < smallest_b:
        biggest_a = smallest_b    
    if t == 1:
        print(0)
    else:
        print(abs(biggest_a - smallest_b))
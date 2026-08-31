t = int(input()) # read a line with a single integer
for i in range(t):
    x = int(input())
    if x == 1:
        print(0)
    else:
        curr = x
        num_3 = 0
        while(curr%3 == 0):
            num_3 += 1
            curr = curr//3
        curr = x
        num_2 = 0
        while(curr%2 == 0):
            num_2 += 1
            curr = curr//2
        if num_3 < num_2:
            print(-1)
        else:
            curr = x
            curr = curr//(3**num_3)
            curr = curr//(2**num_2)
            if curr != 1:
                print(-1)
            else:
                print(num_3 - num_2 + num_3)
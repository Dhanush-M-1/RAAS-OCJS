t = int(input())
input_index = 0

while input_index < t:
    n = int(input())
    k = n
    x = 0
    y = 0
    if k == 1:
        print("0")
    else:
        while k > 1:
            if k % 3 == 0:
                k = k/3
                x = x + 1
            elif k % 2 == 0:
                k = k/2
                y = y + 1
            else:
                break
        if x >= y and k == 1:
            print(str(2 * x - y))
        else:
            print("-1")
    input_index = input_index + 1
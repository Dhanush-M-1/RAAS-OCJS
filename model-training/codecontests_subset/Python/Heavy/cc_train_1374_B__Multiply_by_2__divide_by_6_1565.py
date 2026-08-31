for _ in range(int(input())):
    n = int(input())
    if n == 1:
        print("0")
    elif n == 2:
        print("-1")
    else:
        if(n%3 != 0):
            print("-1")
        else:
            k = n
            temp1 = 0
            temp2 = 0
            while k%3 == 0:
                k = k//3
                temp1 = temp1 + 1
            while k%2 == 0:
                k = k//2 
                temp2 = temp2 + 1
            if k == 1:
                if temp1 >= temp2:
                    print(2*temp1 - temp2)
                else:
                    print("-1")
            else:
                print("-1")
    
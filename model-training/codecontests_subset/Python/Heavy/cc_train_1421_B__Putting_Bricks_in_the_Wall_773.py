def main():
    n = int(input())
    
    x_12 = int(input()[1])
    x_2 = input()
    x_21 = int(x_2[0])
    x_2n = int(x_2[-1])
    if n >= 5:
        for i in range(3, n-1):
            input()
    if n == 3:
        x_n1 = x_2n
    else:
        x_n1 = int(input()[-1])
    x_n = int(input()[-2])

    
    if sum([x_12, x_21, x_n1, x_n]) == 0 or sum([x_12, x_21, x_n1, x_n]) == 4:
        print(2)
        print("1 2")
        print("2 1")
    elif sum([x_12, x_21, x_n1, x_n]) == 1:
        print(1)
        if x_12 == 1:
            print("2 1")
        elif x_21 == 1:
            print("1 2")
        elif x_n1 == 1:
            print(f'{n} {n-1}')
        else:
            print(f"{n-1} {n}")
    elif sum([x_12, x_21, x_n1, x_n]) == 2:
        if x_12 and x_21:
            print(0)
        elif x_n1 and x_n:
            print(0)
        elif x_12 and x_n1:
            print(2)
            print("2 1")
            print(f"{n-1} {n}")
        elif x_12 and x_n:
            print(2)
            print("2 1")
            print(f"{n} {n-1}") 
        elif x_21 and x_n:
            print(2)
            print("1 2")
            print(f"{n} {n-1}")  
        else:
            print(2)
            print("1 2")
            print(f"{n-1} {n}")   
    elif sum([x_12, x_21, x_n1, x_n]) == 3:
        print(1)
        if x_12 == 0:
            print("2 1")
        elif x_21 == 0:
            print("1 2")
        elif x_n1 == 0:
            print(f'{n} {n-1}')
        else:
            print(f"{n-1} {n}")

l = int(input())
for i in range(l):
    main()

        




    
  

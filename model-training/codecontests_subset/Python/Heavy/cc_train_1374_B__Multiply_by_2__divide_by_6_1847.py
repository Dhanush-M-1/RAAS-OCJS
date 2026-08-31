def get_steps(n):
     
    if n == 1:
        return 0

    if n%3 != 0:
        return(-1)

    else:
        if (n%2 == 0):
            steps = get_steps(n/6)
            if steps == -1:
                return (-1)
            else:
                return (1 + steps)
        else: 
            steps = get_steps(n/3)
            if steps == -1:
                return (-1)
            else:
                return (2 + steps)

for t in range(int(input())):
    print(get_steps(int(input())))

    
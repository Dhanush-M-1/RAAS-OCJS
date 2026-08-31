t = int(input())

for i in range(0,t):
    n = int(input())
    c1 = 0
    c2 = 0
    s = input()
    L = list(s)

    if L[0] == '>' and L[n-1] == '>':
        print('0')
        continue

    elif L[0] == '<' and L[n-1] == '<':
        print('0')
        continue

    elif L[0] == '>' and L[n-1] == '<':
        print('0')
        continue

    else:
        for j in range(0,n):
            if L[j] == '<':
                c1+=1
            else:
                break
            if L[n-1-j] == '>':
                c2+=1
            else:
                break


    if(c1<c2):
        print(c1)
    else:
        print(c2)


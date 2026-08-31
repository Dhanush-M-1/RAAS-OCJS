def findit(n, st):
    for i in range(n):   # Loop over all starting positions
        for j in range(1, n//4 + 1):  # Loop over all possible jumps
            if (i+4*j < n and st[i] == '*' and st[i+j] == '*' and st[i+2*j] == '*' and st[i+3*j] == '*' and st[i+4*j] == '*'):
                # print('yes for i = ' + str(i) + " and j = " + str(j))
                print('yes')
                return
    print('no')

# print ("Enter length of string")
n = int(input())
# print ("Enter the string")
st = input()
findit(n, st)

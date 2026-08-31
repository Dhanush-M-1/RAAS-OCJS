#n, k = map(int, input().split(" "))        # read multiple integers into different variables
#L = [int(x) for x in input().split()]      # read multiple integers into a list
#print(' '.join(map(str, L)))               # print multiple integers in one line

a, b = map(int, input().split(" "))        # read multiple integers into different variables
s = 0
burnt = 0
while (a > 0) :
    s += a
    burnt += a
    a = burnt // b
    burnt %= b

print(s)

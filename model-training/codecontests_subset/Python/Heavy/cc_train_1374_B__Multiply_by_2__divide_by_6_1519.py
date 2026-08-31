
def solve(lt):
    steps = 0
    i = 0
    while(lt%3==0):
        i += 1
        lt /= 3
    j = 0
    while(lt%2==0):
        j += 1
        lt /= 2
    if lt != 1:
        return -1
    elif j > i:
        return -1
    else:
        steps = (2*i) - j
    return steps    
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
if __name__ == "__main__":
    n = inp()
    in_lst = []
    for i in range(n):
        #m = inp()
        in_lst.append(inp())
    for i in range(n):
        print(solve(in_lst[i]))
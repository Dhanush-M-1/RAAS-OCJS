# the key is to understand that what matters is the head of <<<< and the tail of >>>> and the rest deletes itself
def find_min_dels(str):
    n = len(str)
    ind1 = n
    ind2 = n-1
    for i in range(n-1):
        if str[i] == ">":
            ind1 = i
            break
    for i in range(n-1,-1,-1):
        if str[i] == "<":
            ind2 = i
            break
    return min(ind1,n-1-ind2)

def read_input (flag=0):
    if flag > 0:
        return input()
    return int(input())

if __name__ == '__main__':
    t = read_input()
    for i in range(t):
        n = read_input()
        s = read_input(1)
        assert len(s) == n
        print(find_min_dels(s))
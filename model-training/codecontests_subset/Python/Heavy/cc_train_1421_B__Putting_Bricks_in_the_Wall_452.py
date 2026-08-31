import sys
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return list(map(int,input().split()))
        
def main():
    t = inp()
    for _ in range(0, t):
        line  = inp()
        matrix = []
        for _ in range(0, line):
            matrix.append(insr())
        a = helper(matrix, '1', '0')
        if (a == None):
            a = helper(matrix, '0', '1')
        if a != None:
            print(len(a))
            for c in a:
                print('{} {}'.format(c[0], c[1]))


def helper(matrix, top, bottom):
    ans = []
    if matrix[0][1] != top:
        ans.append((1,2))
    if matrix[1][0] != top:
        ans.append((2,1))
    if matrix[len(matrix)-1][len(matrix[0])- 2] != bottom:
        ans.append((len(matrix),len(matrix[0]) - 1))
    if matrix[len(matrix)-2][len(matrix[0]) - 1] != bottom:
        ans.append((len(matrix) - 1,len(matrix[0])))
    if len(ans) <= 2:
        return ans
    return None
if __name__ == "__main__":
    main()
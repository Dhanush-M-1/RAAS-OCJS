'''def Team():
    n = int(input())
    pS = 0
    for i in range(n):
        if(temp:=sum(list(map(int, input().split(' '))))) >= 2:
            pS += 1
    print(pS)
    return None


def NextRound():
    n, k = map(int, input().split(' '))
    scores = list(map(int, input().split(' ')))
    cmp = scores[k-1]
    advanced = sum([((i>=cmp)and(i>0)) for i in scores])
    print(advanced)
    return None
 


def DominoPiling():
    m, n = map(int, input().split(' '))
    if(m%2==0) or (n%2==0):
        print(m*n//2)
    else:
        if m == 1 or n == 1:
            print(max(m, n)//2)
        else:            
            print(min(m, n)//2*max(m,n) + max(m, n)//2)
    return None


def Bit():
    n = int(input())
    ins = [input() for i in range(n)]
    x = 0
    for i in ins:
        if '+' in i:
            x += 1
        else:
            x -= 1
    print(x)
    return None


def PetyaAndStrings():
    A = input()
    B = input()
    A = A.lower()
    B = B.lower()
    if A > B:
        print(1)
    elif A == B:
        print(0)
    else:
        print(-1)
    return None

def BeautifulMatrix():
    matrix = [list(map(int, input().split(' '))) for i in range(5)]
    posrow = [i for i in range(5) if 1 in matrix[i]]
    poscol = [j for j in range(5) if matrix[posrow[0]][j] == 1]
    position = (posrow[0], poscol[0])
    mid = (2, 2)
    minMoves = abs(mid[0] - position[0]) + abs(mid[1] - position[1])
    print(minMoves)
    return None  

'''
def HelpfulMaths():
    boardsum = input()
    nums = boardsum.split('+')
    nums = sorted(nums)
    ansStr = "+".join(nums)
    print(ansStr)
    return None

def main():
    #Team()
    #NextRound()
    #DominoPiling()
    #Bit()
    #PetyaAndStrings()
    #BeautifulMatrix()
    HelpfulMaths()

    
main()

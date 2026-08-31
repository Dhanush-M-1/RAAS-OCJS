from collections import *
from itertools import *
from bisect import *

def inp():
    return int(input())
def arrinp():
    return [int(x) for x in input().split()]

def main():
    t = inp()
    for _ in range(t):
        n = inp()
        grid = []
        for i in range(n):
            grid.append([x for x in input()])
        x,y = grid[1][0], grid[0][1]
        p,q = grid[n-1][n-2], grid[n-2][n-1]
        #print(x,y, 'x and y')
        #print(p,q, 'p and q')
        ans_coordinates = []
        ans = 0
        if(x==y):
            if(x=='0'):
                #make p and q: 1
                if(p!='1'):
                    ans +=1
                    ans_coordinates.append([n, n-1])
                if(q!='1'):
                    ans +=1
                    ans_coordinates.append([n-1, n])
            elif(x=='1'):
                #make p and q: 0
                if(p!='0'):
                    ans +=1
                    ans_coordinates.append([n, n-1])
                if(q!='0'):
                    ans +=1
                    ans_coordinates.append([n-1, n])
        elif(x!=y):
            if(p==q):
                if(p=='0'):
                    #make both x and y as 1
                    if(x == '0' and y=='1'):
                        ans +=1
                        ans_coordinates.append([2,1])
                    elif(x=='1' and y=='0'):
                        ans += 1
                        ans_coordinates.append([1,2])
                elif(p=='1'):
                    #make both x and y as 0
                    if(x == '0' and y=='1'):
                        ans +=1
                        ans_coordinates.append([1,2])
                    elif(x=='1' and y=='0'):
                        ans += 1
                        ans_coordinates.append([2,1])
                        
            elif(p!=q):
                #make both x and y as 1
                #make both p and q as 0
                if(x=='1' and y=='0'):
                    ans +=1
                    ans_coordinates.append([1,2])
                elif(x=='0' and y=='1'):
                    ans += 1
                    ans_coordinates.append([2,1])
                if(p=='1' and q == '0'):
                    ans +=1
                    ans_coordinates.append([n,n-1])
                elif(p=='0' and q=='1'):
                    ans +=1
                    ans_coordinates.append([n-1,n])
        print(ans)
        for co in ans_coordinates:
            print(*co, sep = ' ')


if __name__ == '__main__':
    main()
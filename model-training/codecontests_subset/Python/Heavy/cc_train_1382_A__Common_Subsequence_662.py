'''

                            Online Python Compiler.
                Code, Compile, Run and Debug python program online.
Write your code in this editor and press "Run" button to execute it.

'''
def solve():
    n,m =[int(x) for x in input().split()]
    l = [int(x) for x in input().split()]
    l2 = [int(x) for x in input().split()]
    a =set(l)
    b = set(l2)
    a  = a&b
    if (a):
        print("YES")
        print("1 " ,a.pop())
    else:
        print("NO")
    return




t = int(input())
for _ in range(t):
    solve()

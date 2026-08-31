import sys
from os import path
if(path.exists('input.txt')):
    sys.stdin = open("input.txt","r")
    sys.stdout = open("output.txt","w")









def solve():
    n  = int(input().strip())
    a = [int(i) for i in input().rstrip().split()]
    if(a[-1] - a[0] - a[1]) >= 0 :
        print(f"1 2 {n}" )
    else:
        print(-1)





def main():
    tc = int(input().strip())
    for case in range(tc):
        solve()






if __name__ == '__main__':
    main()



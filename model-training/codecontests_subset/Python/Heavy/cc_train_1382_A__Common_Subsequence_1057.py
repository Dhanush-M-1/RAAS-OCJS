import io
import os
from sys import stdin, stdout

input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
def solve():
    n,m= map(int,input().split())
    a = list(map(int, input().split()))
    b=set((map(int, input().split())))
    flag=0
    for i in a:
        if i in b:
            flag=1
            print("YES")
            print(1,i)
            break
    if flag==0:
        print("NO")
def main():
    for t in range(int(input())):
        solve()
if __name__ == "__main__":
    main()
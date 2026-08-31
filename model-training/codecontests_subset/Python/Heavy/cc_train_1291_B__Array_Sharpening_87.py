
import math
def solve():
    n = int(input())
    table = list(map(int,input().split()))
    re = True
    for i in range((n+1)//2):
        if(table[i]<i or table[n-i-1] < i):
            re = False
            break
    if(re and n%2==0 and table[(n-1)//2]==(n-1)//2 and table[n//2]==(n-1)//2):
        re = False
    if re:
        print("YES")
    else:
        print("NO")
def main():
    T = 1
    T = int(input())
    while (T):
        solve()
        T-=1

if __name__ == "__main__":
    main()
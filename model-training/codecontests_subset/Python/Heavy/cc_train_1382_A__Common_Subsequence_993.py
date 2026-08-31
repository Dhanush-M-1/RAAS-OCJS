import sys

def solve():
    # code goes here!!         
    T = int(input())
    for tests in range(T):
        n,m = map(int,input().split())
        cnt = [False] * 1010
        for val in list(map(int,input().split())):
            cnt[val] = True
        ans = -1
        for val in list(map(int,input().split())):
            if cnt[val]: 
                ans = val
        if ans == -1 :
            print("NO")
        else :
            print("YES")
            print(1,ans)
        

def main():
    # comment when submit.
    #sys.stdin = open("test.inp","r")
    solve()

if __name__ == '__main__':
    main()


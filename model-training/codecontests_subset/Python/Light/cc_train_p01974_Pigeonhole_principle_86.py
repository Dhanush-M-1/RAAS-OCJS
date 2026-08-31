def main():
    n = int(input())
    a = list(map(int,input().split()))
    for i in a:
        for j in a:
            if(i != j and abs(i-j) % (n-1) == 0):
                print(i,j)
                return 0
                
main()

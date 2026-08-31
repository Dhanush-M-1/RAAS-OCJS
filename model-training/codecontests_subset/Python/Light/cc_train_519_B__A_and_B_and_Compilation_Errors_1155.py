def function1(a,b):
    a.sort()
    b.sort()
    for i in range(len(b)):
        if a[i]!=b[i]:
            error=a[i]
            return error
    return a[i+1]





def main():
    n=int(input())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=list(map(int,input().split()))
    print(function1(a,b))
    print(function1(b,c))
if __name__=='__main__':
    main()


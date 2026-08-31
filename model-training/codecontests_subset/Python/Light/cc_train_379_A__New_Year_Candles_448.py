if __name__ == "__main__":
    a,b=map(int,input().split())
    r=a
    while a>=b:
        c=int(a/b)
        r+=c
        a=c+a%b
    print(r)
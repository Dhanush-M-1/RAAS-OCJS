def function1(a,b):
    hour=0
    n=0
    while a>=1:
        hour+=1
        a-=1
        n+=1
        if n%b==0:
            a+=1
            n=0
    return hour

def main():
    a,b=list(map(int,input().split()))
    print(function1(a,b))

if __name__=='__main__':
    main()



def ii():
    return int(input())
def li():
    return list(map(int,input().split()))
def mi():
    return map(int,input().split())

def main():
    for i in range(ii()):
        x = ii()
        if x ==1:
            print(0)
            continue
        if x%3!=0 or x==0:
            print(-1)
            continue
        k=0
        check=0
        while True:
            if x==1:
                print(k)
                break
            if x%6==0:
                x = x//6
                k+=1
                continue
            if x%6!=0 and x%3==0:
                x = x*2
                k=k+1
                continue
            if x%6!=0 and x%3!=0:
                print(-1)
                break
        


if __name__ == "__main__":
    main()
'''
7
1
2
3
12
12345
15116544
387420489
'''
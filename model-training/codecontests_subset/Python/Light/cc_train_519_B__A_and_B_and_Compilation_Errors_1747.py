def main():
    input()
    a=sorted(list(map(int,input().split())))
    b=sorted(list(map(int,input().split())))
    c=sorted(list(map(int,input().split())))
    for i in b:
        a.remove(i)
    print(a[0])
    for i in c:
        b.remove(i)
    print(b[0])
    
if __name__=='__main__':
    main()
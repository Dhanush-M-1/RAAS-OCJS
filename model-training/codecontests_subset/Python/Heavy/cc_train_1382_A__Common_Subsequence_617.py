for _ in range(int(input())):
    input().split()
    n=input().split()
    m=input().split()
    c=''
    p=0
    if  len(n)<len(m):
        for i in range(len(n)):
            if n[i] in m:
                c=c+n[i]+' '
                p=p+1
                break
    else:
        for i in range(len(m)):
            if m[i] in n:
                c=c+m[i]+' '
                p=p+1
                break
    if len(c)==0:
        print('NO')
    else:
        print('YES')
        print(p,' ',c,sep='')

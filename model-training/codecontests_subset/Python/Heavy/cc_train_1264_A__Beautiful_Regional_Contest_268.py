for _ in range(int(input())):
    _=input()
    tmp=input()
    n=map(int,tmp.split())
    n=list(n)
    a=[1]
    for i,x in enumerate(n[1:]):
        i+=1
        if x==n[i-1]:
            a[-1]+=1
        else:
            a.append(1)
    
    p=0
    for x in a[1:]:
        if p+x+a[0]>len(n)//2:
            break
        p+=x
        if p>a[0]:
            break
    if p<=a[0]:
        print('0 0 0')
        continue
    half=0
    for x in a:
        if half+x>len(n)//2:
            break
        half+=x
    q=half-a[0]-p
    
    if q<=a[0]:
        print('0 0 0')
    else:
        print('{} {} {}'.format(a[0],p,q))
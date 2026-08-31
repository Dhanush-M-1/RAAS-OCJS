n = int(input())
for k in range(n):
    st,st1 = input().split()
    if st>=st1:
        a = ''.join(sorted(st))
        if a<st1:
            st = list(st)
            a = list(a)
        
            for i in range(len(st)):
                if st[i]!=a[i]:
                    b = st[i]
                    st[i]= a[i]
                    for j in range(len(st)-1,-1,-1):
                        if st[j]==a[i]:
                            st[j]=b
                            break
                        
                    st = "".join(st)
                    break
    if st<st1:
        print(st)
    else:
        print("---")
                

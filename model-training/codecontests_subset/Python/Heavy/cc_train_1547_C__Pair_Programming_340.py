

def ii():  return int(input())
def si():  return input()
def mi():  return map(int,input().strip().split(" "))
def msi(): return map(str,input().strip().split(" "))
def li():  return list(mi())



for _ in range(ii()):
    input()
    k,m,n = mi()
    a = li()
    b = li()
    l = []
    p = 0
    i = 0
    j = 0
    f = 1
    while(p<m+n):
        p += 1
        if(i<m and k>=a[i]):
            if(a[i]):
                l.append(a[i])
            else:
                l.append(a[i])
                k += 1
            i += 1
        elif(j<n and k>=b[j]):
            if(b[j]):
                l.append(b[j])
            else:
                l.append(b[j])
                k += 1
            j += 1
        else:
            f = 0
            break
        # print(k,i,j,p)
    if(f):
        for i in l:
            print(i,end=" ")
        print()
    else:
        print(-1)
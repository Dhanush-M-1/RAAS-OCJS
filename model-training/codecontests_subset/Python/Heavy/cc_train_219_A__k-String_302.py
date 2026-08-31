from collections import Counter
from collections import OrderedDict

k=int(input())
s=input()

l=len(s)
if l%k==0:
    a=l/k

    c=OrderedDict(Counter(s))
    d=OrderedDict()
    if all(c[i]%k==0 for i in c):
        d={i:c[i]//k for i in c}
        while all(c[i]!=0 for i in c):
            for i in c:
                for j in range(int(d[i])):
                    if c[i]!=0:
                        print(i,end="")
                        c[i]-=1
                    else:
                        pass
    else:
        print(-1)

else:
    print(-1)
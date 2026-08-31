import sys
import io, os
def main():
    t=int(input())
    for i in range(t):
        p,c=[],[]
        n=int(input())
        for i in range(n):
            p1,c1=map(int,input().split())
            p.append(p1)
            c.append(c1)
        if p[0]>=c[0]:
            ok=True
        else:
            ok=False
        for i in range(1,len(p)):
            if p[i]>=p[i-1] and c[i]>=c[i-1]:
                if p[i]-p[i-1]>=c[i]-c[i-1] and p[i]>=c[i]:
                    continue
                else:
                    ok=False
                    break
            else:
                ok=False
                break
        if ok==False:
            print("NO")
        else:
            print("YES")
        


if __name__ == "__main__": 
    main() 

 


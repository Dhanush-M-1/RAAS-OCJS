"""
NTC here
"""
from sys import stdin
# import threading
# setrecursionlimit(10**6)
# threading.stack_size(2**26)
 
def iin(): return int(stdin.readline())
def lin(): return list(map(int, stdin.readline().split()))
 
# range = xrange
# input = raw_input
 
 
def main():
    t=iin()
    while t:
        t-=1
        s,c=input().split()
        s,c=list(s),list(c)
        n1,n2=len(s),len(c)
        i=0
        ch1=0
        while i<n1 and i<n2:
            if ch1:break
            if s[i]<c[i]:
                break
            elif s[i]==c[i]:
                for j in range(i+1,n1):
                    if s[j]==c[i]:
                        pass
                    elif s[j]<c[i]:
                        s[i],s[j]=s[j],s[i]
                        ch1=1
                        break
                
                if s[i]<c[i]:
                    break
            else:
                ch=0
                for j in range(i+1,n1):
                    if s[j]==c[i]:
                        ch=j
                    elif s[j]<c[i]:
                        s[i],s[j]=s[j],s[i]
                        ch1=1
                        break
                else:
                    if ch:
                        s[i],s[ch]=s[ch],s[i]
                        ch1=1
                if s[i]<c[i]:
                    break
            i+=1
        # print(s)
        if s<c:
            print(''.join(s))
        else:
            print('---')
 
 
 
 
        
main()
#threading.Thread(target=main).start()
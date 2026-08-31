# lET's tRy ThIS...

import math
import os
import sys

#-------------------BOLT------------------#
#-------Genius----Billionare----Playboy----Philanthropist----NOT ME:D----#

input = lambda: sys.stdin.readline().strip("\r\n")
def cin(): return sys.stdin.readline().strip("\r\n")
def fora(): return list(map(int, sys.stdin.readline().strip().split()))
def string(): return sys.stdin.readline().strip()
def cout(ans): sys.stdout.write(str(ans))
def endl(): sys.stdout.write(str("\n"))
def ende(): sys.stdout.write(str(" "))

#---------ND-I-AM-IRON-MAN------------------#


def main():
    for _ in range(int(input())):
        #LET's sPill the BEANS
        n=int(cin())
        l=fora()
        if(n//2>3):
            mp={}
            mp=dict.fromkeys(l,0)
            for i in l:
                mp[i]+=1
            cnt=g=s=b=0
            flag=j=1
            for i in mp:
                if(j==1):
                    g+=mp[i]
                    cnt+=mp[i]
                elif(flag):
                    s+=mp[i]
                    cnt+=mp[i]
                    if s>g:
                        flag=0
                else:
                    if(cnt>=n//2):
                        break
                    b+=mp[i]
                    cnt+=mp[i]
                    if(cnt>n//2):
                        b-=mp[i]
                        break
                j+=1
            if(g==0 or s==0 or b==0):
                print("0 "*3,end="")
            elif(g>=s or g>=b):
                print("0 "*3,end="")
            else:
                cout(g)
                ende()
                cout(s)
                ende()
                cout(b)
        else:
            print("0 "*3,end="")
        endl()

if __name__ == "__main__": 
    main()

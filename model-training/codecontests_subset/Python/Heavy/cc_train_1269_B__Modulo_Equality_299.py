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
    # for _ in range(int(input())):
        #LET's sPill the BEANS
        n,m=map(int,cin().split())
        a=fora()
        b=fora()
        a.sort()
        b.sort()
        mp1={}
        mp2={}
        mp1=dict.fromkeys(a,0)
        mp2=dict.fromkeys(b,0)
        for i in a:
            mp1[i]+=1
        for i in b:
            mp2[i]+=1
        if(mp1==mp2):
            cout(0)
        else:
            mint=n+1
            el=0
            for i in mp1:
                if(mint>=mp1[i]):
                    mint=mp1[i]
                    el=i
            l=[]
            for i in mp2:
                if(mp2[i]==mint):
                    l.append(i)
            for i in l:
                x=0
                mp3={}
                if(i>=el):
                    x=i-el
                else:
                    x=m-(el-i)
                for i in mp1:
                    t=(i+x)%m
                    mp3[t]=mp1[i]
                if(mp2==mp3):
                    cout(x)
                    break
        #print(mp1,mp2,mint,el,l)
        # print(mp3)
        # endl()

if __name__ == "__main__": 
    main()
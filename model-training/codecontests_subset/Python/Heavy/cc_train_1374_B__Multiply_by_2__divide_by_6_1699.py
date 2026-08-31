import sys,collections,math
######################################
def in_out():
	sys.stdin = open('input.txt', 'r')  
	sys.stdout = open('output.txt', 'w')
#in_out()
######################################

for _ in range(int(input())):
    n = int(input())
    #s=input()
    #x,y,n = map(int,input().split())
    #arr = list(map(int,input().split()))
    three =0
    two = 0
    while n%3==0:
        n=n//3
        three+=1
    while n%2==0:
        n=n//2
        two+=1
    if n>1:
        print(-1)
        continue
    if two>three:
        print(-1)
        continue
    req = three-two
    print(req*2+two)
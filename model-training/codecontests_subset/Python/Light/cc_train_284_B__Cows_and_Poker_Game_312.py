n=int(input())
s=input()
if s.count('F')==n:
    print(0)
    exit()
if s.count('I')==0:
    print(s.count('A'))
    exit()
if s.count('I')==1:
    print(1)
    exit()
if s.count('I')>1:
    print(0)
    exit()

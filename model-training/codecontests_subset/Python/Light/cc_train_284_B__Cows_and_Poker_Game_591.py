n = int(input())
s = str(input())

s = s.replace('F','')
if s.count('I')>=2:
    print(0)
elif s.count('I')==1:
    print(1)
elif s.count('I')==0:
    print(s.count('A'))
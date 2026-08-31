n=int(input())
s=(input())
ones=list()
zero=list()
on=0
ze=0
if(s.count('1')!=s.count('0')):
    print(1)
    print(s)
    exit()
for i in range(0,n):
    if(s[i]=='1'):
        on=on+1
        ones.append(on)
        zero.append(ze)
    else:
        ze=ze+1
        zero.append(ze)
        ones.append(on)
total_ones=ones[-1]
total_zero=zero[-1]
for i in range(0,n):
    if(zero[i]!=ones[i] and (total_ones-ones[i]!=total_zero-zero[i])):
        print(2)
        print(s[0:i+1],s[i+1:])
        break
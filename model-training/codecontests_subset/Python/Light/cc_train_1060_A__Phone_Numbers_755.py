n=int(input())
ch=input()
l=list(ch)
if l.count('8')>=len(ch)//11:
    print(len(ch)//11)
elif '8' not in l:
    print(0)
elif l.count('8')<len(ch)//11:
    print(l.count('8'))
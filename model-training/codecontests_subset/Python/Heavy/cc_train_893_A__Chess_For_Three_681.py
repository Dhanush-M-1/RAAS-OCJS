#chess for 3, edu 33 A

def ni():
    s=input()
    while len(s)==0:
        s=input()
    try:
        return int(s)
    except:
        return 0

def nia():
    s=input()
    while len(s)==0:
        s=input()
    s=s.split()
    iVal=[];
    for i in range (len(s)):
        iVal.append(int(s[i]))
    return iVal

def solve():
    games=ni()
    winner=[None]*games
    for i in range (games):
        winner[i]=ni()
    last=winner[0]
    if last==3:     #first game winner must be 1 or 2
        return False
    loser=3-last
    spect=3
    for i in range(1, games):
        if winner[i]==last:     #same winner, swap spect and loser
            temp=loser
            loser=spect
            spect=temp
        else:
            if winner[i]==loser:  #new winner cannot be last loser
                return False
            else:
                spect=loser
                loser=last
                last=winner[i]
    return True

if solve():
    print("YES")
else:
    print("NO")

trial = int(input())
for t in range(trial):
    targ = int(input())
    cnt = 0
    while True:
        if targ < 10:
            print(cnt)
            break
        else:
            maxtarg = 0
            for word in range(1,len(str(targ))):
                maxtarg = max( maxtarg , int(str(targ)[0:word]) * int(str(targ)[word:len(str(targ))]))
            targ = maxtarg
            cnt += 1
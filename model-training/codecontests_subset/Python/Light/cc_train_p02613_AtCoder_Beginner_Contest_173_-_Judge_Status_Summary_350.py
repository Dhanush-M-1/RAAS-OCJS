b={'AC':0,'WA':0,'TLE':0,'RE':0}
for _ in range(int(input())):
    a=input()
    b[a]+=1
for key,val in b.items():
    print(key,'x',val)


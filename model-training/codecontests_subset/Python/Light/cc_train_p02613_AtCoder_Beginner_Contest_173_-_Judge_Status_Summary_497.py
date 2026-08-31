g={'AC':0,'WA':0,'TLE':0,'RE':0}
for i in range(int(input())):g[input()]+=1
for i in g:
    print(i+' x '+str(g[i]))
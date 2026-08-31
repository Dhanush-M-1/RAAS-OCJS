ans = {'AC':0,'WA':0,'TLE':0,'RE':0}
for _  in range(int(input())):
  ans[input()] += 1
for k in ans:
  print("%s x %d"%(k,ans[k]))
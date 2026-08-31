def main():

    from sys import stdin
     
    n,m = list(map(int,stdin.readline().split()))
    a = list(map(int,stdin.readline().split()))
    b = list(map(int,stdin.readline().split()))
     
    ans = 2*m
     
    counta,countb = {},{}
     
    for i in range(n):
     
    	if a[i] in counta: counta[a[i]] += 1
    	else: counta[a[i]] = 1
     
    	if b[i] in countb: countb[b[i]] += 1
    	else: countb[b[i]] = 1
     
    choice = counta[a[0]]
     
    work1 = list(filter(lambda x: counta[x]==choice, counta.keys()))
    work2 = list(filter(lambda x: countb[x]==choice, countb.keys()))
    assert (len(work1)==len(work2))
     
    hope = set()
    for jt in range(len(work2)):
    	hope.add((work2[jt]-work1[0])%m)
     
    for h in hope:
    	if (ans==2*m or (h<ans and h!=0)) and sorted(list(map(lambda x: (x+h)%m, work1)))==sorted(work2):
    		ans = min(ans,h)
     
    if ans==2*m: print(0)
    else: print(ans)

if __name__ == "__main__":
    main()
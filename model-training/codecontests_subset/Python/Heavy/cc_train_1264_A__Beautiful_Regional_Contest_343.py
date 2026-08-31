from collections import Counter,defaultdict
import math
t = int(input())
for _ in range(t):
    n = int(input())
    ls = list(map(int,input().strip().split()))
    if n<3:
        print("0 0 0")
        continue
    wins = ls[:n//2].copy()
    templs = ls[n//2:].copy()
    ls.clear()
    ls = templs[:].copy()
    check = wins[-1]
    count_dic = defaultdict(int)
    medals = 0
    if ls.count(check)>0:
        temp = []
        for val in wins:
            if val==check:
                break
            temp.append(val)
            medals += 1
            count_dic[val] += 1
        wins.clear()
        wins = temp.copy()
    else:
        for val in wins:
            medals += 1
            count_dic[val] += 1
    if len(count_dic)<3:
        print("0 0 0")
    else:
        #print(wins)
        #print(medals)
        #print(count_dic)
        max_gold_medals = medals/3
        #if int(max_gold_medals)==max_gold_medals:
        #    max_gold_medals = int(max_gold_medals) - 1
        #else:
        max_gold_medals = math.floor(max_gold_medals)
        gold = silver = bronze = 0
        while gold>=silver or gold>=bronze:
            temp_max_gold_medals = max_gold_medals
            gold=silver=bronze=0
            for key,val in sorted(count_dic.items(),reverse=True):
                if val<=temp_max_gold_medals:
                    gold += val
                    temp_max_gold_medals -= val
                else:
                    temp_max_gold_medals = 0
                    if silver<=gold:
                        silver += val
                    else:
                        bronze += val
            max_gold_medals -= 1
        if gold<=0:
            print("0 0 0")
        else:
            print(gold,silver,bronze)
            
        
        

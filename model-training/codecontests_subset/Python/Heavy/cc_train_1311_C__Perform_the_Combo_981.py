import sys
input = sys.stdin.readline


#from collectinons import defaultdict
def main():
    for _ in range(int(input())):
        n, m = map(int,input().split())   
        s = input()
        p = list(map(int, input().split()))
        
        ans = {}
        cnt = {}
        ch = {}
        for i in range(n):
            if s[i] in ch:
                ch[s[i]] += 1
            else:
                ch[s[i]] = 1
                
            cnt[i] = ch.copy()
            #print(cnt)
        
        for i in range(m):
            for el in cnt[p[i] - 1]:
                if el in ans:
                    ans[el] += cnt[p[i] - 1][el]
                else:
                    ans[el] = cnt[p[i] - 1][el]


                    
        for el in cnt[n - 1]:
            if el in ans:
                ans[el] += cnt[n - 1][el]
            else:
                ans[el] = cnt[n - 1][el]
                
            

                    
        for i in range(97, 97 + 26):
            if chr(i) in ans:
                print(ans[chr(i)], end = " ")
            else:
                print(0, end = " ")
        print()
                

main()
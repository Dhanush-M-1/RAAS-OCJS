#from collections import defaultdict
if __name__ == "__main__":
    q = int(input())
    for _ in range(q):
        s = input()
        pairs = [[] for _ in s]
        for i in range(len(s) - 2):
            if s[i] == s[i+1]:
                pairs[i].append(i+1)
            if s[i] == s[i+2]:
                pairs[i].append(i+2)
        if len(s) > 1 and s[-2] == s[-1]:
            pairs[-2].append(len(s) - 1)

        # alg
        cnt = 0
        changed = set()
        for i in range(len(s)):
            if i in changed or len(pairs[i]) == 0:
                continue
            for pair in pairs[i]:
                cnt += 1
                changed.add(pair)
        print(cnt)
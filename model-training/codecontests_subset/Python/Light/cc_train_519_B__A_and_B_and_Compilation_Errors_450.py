## 519 B
n = int(input())
a = [int(x) for x in input().split(' ')]
bs = [int(b) for b in input().split(' ')]
cs = [int(c) for c in input().split(' ')]
a.sort()
bs.sort()
cs.sort()
bs.append(10E9 + 1)
cs.append(10E9 + 1)
cs.append(10E9 + 1)
for i, b in enumerate(bs):
    if a[i] != b:
        print(a[i])
        break
        
for i, c in enumerate(cs):
    if bs[i] != c:
        print(bs[i])
        break
            
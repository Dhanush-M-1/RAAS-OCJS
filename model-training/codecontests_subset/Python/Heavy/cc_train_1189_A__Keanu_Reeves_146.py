n = int(input())
s = str(input())

def is_good(s):
    l = len(s)
    ones = 0
    for i in s:
        if i=='1':
            ones += 1
    zeros = l - ones
    if zeros == ones:
        return(False)
    else:
        return(True)

nsplits = 0
splits = []

def keanu(n,s):
    global nsplits
    global splits
    if n==1:
        nsplits += 1
        splits.append(s)
    else:
        for i in range(n):
            j = s[0:n-i]
            if is_good(j):
                nsplits += 1
                splits.append(j)
                keanu(len(s[n-i::]), s[n-i::])
                break
            else:
                continue

keanu(n,s)
print(nsplits)
for split in splits:
    print(split, end = " ")

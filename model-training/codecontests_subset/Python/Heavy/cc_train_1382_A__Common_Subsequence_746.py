def subSeq(a,b):
    a.sort()
    b.sort()
    j = 0
    found = "NO"
    sub = []
    for i in range(len(a)):
        while b[j] < a[i] and j < len(b)-1:
            j += 1
        if a[i] == b[j]:
            found = "YES"
            sub.append(a[i])
            return found,sub
    return found,sub
        
if __name__ == '__main__':
    tests = int(input())
    for t in range(tests):
        n, m = map(int,input().split())
        a = list(map(int,input().split()))
        b = list(map(int,input().split()))
        result,sub= subSeq(a,b)
        if result == "YES":
            print(result)
            print(len(sub),sub[0])
        else:
            print(result)
        
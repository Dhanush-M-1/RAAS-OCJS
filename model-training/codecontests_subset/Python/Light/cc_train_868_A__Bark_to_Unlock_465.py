def canUnlock(pwds,pwd):
    if pwd in pwds:
        return "YES"
    
    firstLetter = False
    secondLetter = False
    for p in pwds:
        if p[0]==pwd[1]:
            firstLetter = True
        if p[1]==pwd[0]:
            secondLetter = True
    if firstLetter and secondLetter:
        return "YES"
    
    return "NO"
     
if __name__ == "__main__":
    pwd = input()
    N = int(input())
    pwds = []
    for i in range(N):
        pwds.append(input())
    print(canUnlock(pwds,pwd))
a,b=map(int,input().split())
hours=a
usedcan=a
while usedcan>=b:
    newcan=usedcan//b
    usedcan=usedcan-(newcan*b)+newcan
    hours+=newcan
print(hours)

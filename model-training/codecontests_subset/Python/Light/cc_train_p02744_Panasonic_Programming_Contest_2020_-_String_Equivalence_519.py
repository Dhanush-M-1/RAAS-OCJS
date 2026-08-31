n = int(input())
ans = ["a"]
for i in range(n-1):
    nans = []
    
    for s in ans:
        m = max(s)
        for x in range(ord(m)-95):
            nans.append(s+ chr(97+x))
            
    ans = nans
print("\n".join(ans))
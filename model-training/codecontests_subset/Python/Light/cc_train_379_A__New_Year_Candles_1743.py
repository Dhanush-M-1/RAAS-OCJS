a,b=[int(x) for x in input().split()]
count=a
def burn(a,b,count):
    if a<b:
        return count
    else:
        count+=a//b
        a=(a//b)+(a%b) 
        return burn(a,b,count)
ans=burn(a,b,count)
print(ans)
n,l=input().split()
n=int(n)
l=int(l)
ans=n
used=n
unuse=0
while (used+unuse)>=l:
    use=(used+unuse)//l
    ans+=use
    unuse=(used+unuse)%l
    used=use
print(ans)
a, b, c = map(int, input().split())
print("YNeos"[not(a+b+c==max(a,b,c)*2)::2])
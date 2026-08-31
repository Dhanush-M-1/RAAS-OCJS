L=int(input().split()[1])
print(L//max(d for d in map(int,input().split())if L%d==0))
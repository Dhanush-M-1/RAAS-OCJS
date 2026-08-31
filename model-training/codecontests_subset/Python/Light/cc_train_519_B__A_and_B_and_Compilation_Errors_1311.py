n = int(input())
seqs=[]
for i in range(3):
    seqs.append(list(map(int,input().split(" ")))[:n])
    n = n-1
sum1 = sum(seqs[0])
sum2 = sum(seqs[1])
sum3 = sum(seqs[2])
print(sum1 - sum2)
print(sum2 - sum3)
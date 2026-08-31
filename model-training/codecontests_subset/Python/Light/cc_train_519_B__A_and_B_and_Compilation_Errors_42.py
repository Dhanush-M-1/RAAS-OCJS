n = int(input())
e1 = list(map(int, input().split()))
e2 = list(map(int, input().split()))
e3 = list(map(int, input().split()))

count1, count2, count3 = 0, 0, 0

for i in range(len(e3)):
  count1 += e1[i]
  count2 += e2[i]
  count3 += e3[i]

count2 += e2[-1]
count1 += e1[-1]
count1 += e1[-2]

print(count1 - count2)
print(count2 - count3)
 					 					  						  	   					
trees = []
cut = 0
n = int(input())

for i in range(n):
  x, h = map(int,input().split())
  trees.append([x,h])


for tree in range(len(trees)):
  if tree == 0:
    cut+=1
  elif tree == len(trees)-1:
    cut+=1
  elif trees[tree][0]-trees[tree][1] > trees[tree-1][0]:
    cut+=1
  elif trees[tree][0]+trees[tree][1] < trees[tree+1][0]:
    cut+=1
    trees[tree][0]=trees[tree][0]+trees[tree][1]

print(cut)
 			 	  	 	      		  	 	 	   		
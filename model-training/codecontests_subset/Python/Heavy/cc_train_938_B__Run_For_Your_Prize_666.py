# number of elements
n = int(input())

# Below line read inputs from user using map() function
positions = list(map(int, input().strip().split()))[:n]

#global variable
me = meVAR = 1
myFrnd = myFrndVAR = 1000000    #10^6
itr = 0

while itr<len(positions):
    #print("this is itr : {}".format(itr))
    meVAR=positions[itr]-me
    myFrndVAR=myFrnd-positions[itr]
    if meVAR>myFrndVAR:
        break
    itr+=1
#print(itr) # the first itr that not follows me<frnd OR itr=len_of_position_list

########################## upper portion done ###################################3

positions[itr:]=reversed(positions[itr:])
#print(positions)


########################## Computing Required Seconds ###############################

minSecondsME=0
minSecondsFrnd=0
for indx, value in enumerate(positions):
  #print(indx,value)
  if indx<itr:
      minSecondsME += (value-me)
      me = value
  else:
      minSecondsFrnd += (myFrnd-value)
      myFrnd=value

#print(minSecondsME)
#print(minSecondsFrnd)
result=max(minSecondsME,minSecondsFrnd)
print(result)


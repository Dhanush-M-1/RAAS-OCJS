n = int(input())
s = input()
dic = {}
for x in s:
	if x in dic:
		dic[x]+=1
	else:
		dic[x] = 1
if 'I' not in dic:
	dic['I']=0
if 'A' not in dic:
	dic['A'] = 0
if 'F' not in dic:
	dic['F'] = 0

if dic['I']==0:
	print(dic['A'])
elif dic['I']==1 and (dic['A']>0 or dic['F']>0):
	print(dic['I'])
else:
	print(0)

# def f(n,k,ls):
# 	print(ls,type(n),k)
# 	if k==0 and (n=="" or n==None):
# 		return ls
# 	elif k==0:
# 		return -1;
# 	for x in range(1,len(n)+1):
# 		s =ls.copy()
# 		s.append(n[0:x])
# 		res = f(n[x:],k-1,s) 
# 		if res!=-1:
# 			print("res="+str(res))
			
# f("123456",3,[])
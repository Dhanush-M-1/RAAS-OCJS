n=int(input())
st=input()
if n<11:
    print(0)
else:
    num=st.count("8")
    num2=n//11
    print(min(num,num2))

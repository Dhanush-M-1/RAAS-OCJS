n = int(input())
l = ["a","b","c","d","e","f","g","h","i","j"]
i = 0
def st(s,n,k,m):
  if k == n:
    print(s)
    return
  for i in range(m):
    st(s+l[i],n,k+1,m)
  st(s+l[m],n,k+1,m+1)
st("a",n,1,1)
n,s=[int(el) for el in input().split()]
a=[]
a=[int(el) for el in input().split()]

a.sort()

midl=int((n-1)/2)
med=a[midl]
if med==s:
    print ('0')
    raise SystemExit()

output=s-med

if output>0:
    for i in range(midl+1,n,1):
        if a[i]<s:
            output=output+s-a[i]
        else:
            print (output)
            raise SystemExit()
if output<0:
    output=-output
    for i in range(midl-1,-1,-1):
        if a[i]>s:
            output=output+a[i]-s
        else:
            print (output)
            raise SystemExit()

print (abs(output))

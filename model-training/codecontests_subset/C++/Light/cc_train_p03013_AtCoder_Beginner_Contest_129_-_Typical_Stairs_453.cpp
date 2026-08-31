#import<bits/stdc++.h>
using namespace std;
int i,k,m,n,c[100005],b[100005];
int main()
{
scanf("%d%d",&n,&m);
for(;m--;b[k]=1)scanf("%d",&k);
for(*c=1;i++<n;)c[i]=b[i]?0:((i>1?c[i-2]:0)+c[i-1])%1000000007;
printf("%d",c[n]);
}
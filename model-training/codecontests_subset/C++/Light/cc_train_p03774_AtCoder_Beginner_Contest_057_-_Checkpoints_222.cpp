#include <bits/stdc++.h>
 
int main()
{
  int n,m;
  scanf("%d%d",&n,&m);
  long int i,j,a[n],b[n],c[m],d[m],ans,num,min=1000000000;
  for(i=0;i<n;++i)
      scanf("%ld%ld",&a[i],&b[i]);
  
  for(i=0;i<m;++i)
       scanf("%ld%ld",&c[i],&d[i]);
  
  for(i=0;i<n;++i)
  {
     min=1000000000;
    for(j=0;j<m;++j)
    {
      ans=abs(c[j]-a[i])+abs(d[j]-b[i]);
      if(min>ans)
          { min=ans;
             num=j+1;
          }
      
    }
    printf("%ld\n",num);
  }
}
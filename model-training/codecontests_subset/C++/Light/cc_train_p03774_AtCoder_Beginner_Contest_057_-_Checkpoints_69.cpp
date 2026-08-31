#include<cstdio>
#include<cmath>
using namespace std;
int main(){
  int n,m,a[50],b[50],c[50],d[50],ans,mina;
  scanf("%d %d",&n,&m);
  for(int i=0;i<n;i++)
    scanf("%d %d",&a[i],&b[i]);
  for(int i=0;i<m;i++)
    scanf("%d %d",&c[i],&d[i]);
  for(int i=0;i<n;i++){
    ans=1;
    mina=abs(a[i]-c[0])+abs(b[i]-d[0]);
    for(int j=1;j<m;j++){
      if(mina>abs(a[i]-c[j])+abs(b[i]-d[j])){
        ans=j+1;
        mina=abs(a[i]-c[j])+abs(b[i]-d[j]);
      }
    }printf("%d\n",ans);
  }
}
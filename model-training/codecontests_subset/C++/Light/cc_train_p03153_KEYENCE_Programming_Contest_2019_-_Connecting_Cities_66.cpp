#include <iostream>
using namespace std;
using ll=long long;
ll n,d,a[200000],b[200000],m=1LL<<60,loc,ans;
int main(void){
  cin>>n>>d;
  for(int i=0;i<n;i++){
    cin>>a[i];
    if(m>a[i]){m=a[i];loc=i;}
    if(i)b[i]=min(a[i],b[i-1]+d);
    if(i==0)b[i]=a[i];
  }
  for(int i=n-1;i;i--){
    b[i-1]=min(b[i-1],b[i]+d);
  }
  for(int i=loc-1;i>=0;i--){
    ans+=a[i]+b[i+1]+d;
  }
  for(int i=loc+1;i<n;i++){
    ans+=a[i]+b[i-1]+d;
  }
  cout<<ans<<endl;
}

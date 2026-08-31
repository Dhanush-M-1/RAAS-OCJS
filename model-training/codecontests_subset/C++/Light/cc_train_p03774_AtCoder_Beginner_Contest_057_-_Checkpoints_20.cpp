#include<iostream>
#include<cmath>
using namespace std;

int main(){

  long long n, m, a[50], b[50], c[50], d[50], p[50], min;

  cin>>n>>m;
  for(int i=0;i<n;i++) cin>>a[i]>>b[i];
  for(int i=0;i<m;i++) cin>>c[i]>>d[i];

  for(int i=0;i<n;i++){
    min=10000000000000000;
    for(int j=0;j<m;j++){
      if(llabs(a[i]-c[j])+llabs(b[i]-d[j])<min){
        min=llabs(a[i]-c[j])+llabs(b[i]-d[j]);
        p[i]=j;
      }
    }
  }

  for(int i=0;i<n;i++) cout<<p[i]+1<<endl;

  return 0;
}

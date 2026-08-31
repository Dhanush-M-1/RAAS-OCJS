#include<bits/stdc++.h>
using namespace std;

int main(){
  int n,m;
  cin>>n>>m;
  vector<long long int> a(n),b(n);
  for(int i=0;i<n;i++) cin>>a[i]>>b[i];
  vector<long long int> c(m),d(m);
  for(int i=0;i<m;i++) cin>>c[i]>>d[i];

  for(int i=0;i<n;i++){
    long long int min_dis=1e15;
    int res=-1;
    for(int j=0;j<m;j++){
      if(abs(a[i]-c[j])+abs(b[i]-d[j])<min_dis){
	min_dis=abs(a[i]-c[j])+abs(b[i]-d[j]);
	res=j;
      }
    }
    cout<<res+1<<endl;
    
  }
  return 0;

}

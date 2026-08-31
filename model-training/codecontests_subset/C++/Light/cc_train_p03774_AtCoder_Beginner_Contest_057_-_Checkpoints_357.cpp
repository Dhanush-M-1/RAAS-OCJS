#include <bits/stdc++.h>
using namespace std;

int main() {
  int n,m;
  cin>>n>>m;
  std::vector<int> a(n),b(n),c(m),d(m);
  int kkk,mmm,ans;
  for(int i=0;i<n;i++)cin>>a[i]>>b[i];
  for(int i=0;i<m;i++)cin>>c[i]>>d[i];
  for(int i=0;i<n;i++){
    mmm=-1;
    for(int j=0;j<m;j++){
      kkk=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(mmm>kkk||mmm==-1){mmm=kkk;ans=j;}
    }
    cout<<ans+1<<endl;
  }
}

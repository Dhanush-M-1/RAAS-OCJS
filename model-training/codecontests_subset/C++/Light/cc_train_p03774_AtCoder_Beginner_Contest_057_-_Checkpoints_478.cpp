#include <bits/stdc++.h>
using namespace std;

int main(){
  int n,m;
  cin >> n >> m;
  vector<int> a(n),b(n),c(m),d(m),l(n);
  int kyo;
  for(int i=0;i<n;i++){
    cin >> a[i] >> b[i];
  }
  for(int i=0;i<m;i++){
    cin >> c[i] >> d[i];
  }
  for(int i=0;i<n;i++){
    int kyo=400000001;
    for(int j=0;j<m;j++){
      if(kyo>abs(a[i]-c[j])+abs(b[i]-d[j])){
        kyo=abs(a[i]-c[j])+abs(b[i]-d[j]);
        l[i]=j+1;
      }
    }
    cout << l[i] << endl;
  }
}

#include<iostream>
#include<vector>
#define rep(i, s, n) for (int i=(s); i<(n); i++)
using namespace std;

int main() {
  int n; cin>>n;
  vector<int> a(n);
  rep(i, 0, n) cin>>a[i];

  int cnt=0;
  rep(i, 0, n) {
    int minj=i;
    rep(j, i, n) {
      if (a[minj]>a[j]) minj=j;
    }
    swap(a[i], a[minj]);
    if (i!=minj) cnt++;
  }
  rep(i, 0, n-1) cout<<a[i]<<" ";
  cout<<a[n-1]<<endl;
  cout<<cnt<<endl;
  return 0;
}


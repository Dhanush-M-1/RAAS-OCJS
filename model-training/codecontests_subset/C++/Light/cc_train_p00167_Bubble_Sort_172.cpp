#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  while(cin >> n && n) {
    vector<int> a(n);
    for(int i = 0; i < n; ++i) cin >> a[i];
    int ans = 0;
    for(int i = 0; i < n; ++i) {
      for(int j = 0; j+1 < n-i; ++j) {
        if(a[j] > a[j+1]) {
          swap(a[j], a[j+1]);
          ++ans;
        }
      }
    }
    cout << ans << endl;
  }
}
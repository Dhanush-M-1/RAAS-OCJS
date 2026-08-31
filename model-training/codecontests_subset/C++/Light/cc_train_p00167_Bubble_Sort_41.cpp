#include <iostream>
using namespace std;
int n,a[100],ans=0;

void solve() {
  int fin = n-1;
  while(fin != 0) {
    for(int i=0;i<fin;i++) {
      if(a[i] > a[i+1]) {
        swap(a[i],a[i+1]);
        ans++;
      }
    }
    fin--;
  }
  return;
}

int main() {
  while(cin >> n) {
    if(n==0) break;
    for(int i=0;i<n;i++) {
      cin >> a[i];
    }
    solve();
    cout << ans << endl;
    ans = 0;
  }
  return 0;
}
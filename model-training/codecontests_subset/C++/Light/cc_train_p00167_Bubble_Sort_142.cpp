#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  int n;
  while(cin >> n, n) {
    vector<int> v(n);
    for(int i = 0; i < n; i++) cin >> v[i];

    int ans = 0;
    for(int i = n-1; i >= 0; i--) {
      for(int j = 0; j < i; j++) {
	if(v[j] > v[j+1]) {
	  swap(v[j], v[j+1]);
	  ans++;
	}
      }
    }
    cout << ans << endl;
  }
}